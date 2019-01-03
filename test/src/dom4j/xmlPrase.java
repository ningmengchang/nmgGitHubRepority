package dom4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class xmlPrase {
	@Test
	public void praseDXml() throws DocumentException, IOException {
	    File inputXml = new File("src/dhtmlxxml.xml");
	    SAXReader saxReader = new SAXReader();
	    Document document=saxReader.read(inputXml);       //SAX生成和解析XML文档
	    Element employees = document.getRootElement();    //获得根节点
	    getNodes(employees);
	    writeXml(document,"");
	}
	 public void parserXml(String fileName) {
	        File inputXml = new File(fileName);
	        SAXReader saxReader = new SAXReader();
	        try {
	            Document document=saxReader.read(inputXml);       //SAX生成和解析XML文档
	            Element employees = document.getRootElement();    //获得根节点
	            for(Iterator i = employees.elementIterator(); i.hasNext();){
	                Element employee = (Element) i.next();
	                for(Iterator j = employee.elementIterator(); j.hasNext();){
	                    Element node=(Element) j.next();
	                    System.out.println(node.getName()+":"+node.getText());
	                }
	            }
	        } catch (DocumentException e) {
	            e.printStackTrace();
	        }

	    }
	   /**
		 * 从指定节点开始,递归遍历所有子节点
		 * @author chenleixing
		 */
		public void getNodes(Element node){
			System.out.println("--------------------");
			
			//当前节点的名称、文本内容和属性
			System.out.println("当前节点名称："+node.getName());//当前节点名称
			System.out.println("当前节点的内容："+node.getTextTrim());//当前节点名称
			List<Attribute> listAttr=node.attributes();//当前节点的所有属性的list
			for(Attribute attr:listAttr){//遍历当前节点的所有属性
				String name=attr.getName();//属性名称
				String value=attr.getValue();//属性的值
				System.out.println("属性名称："+name+"属性值："+value);
			}
			
			//递归遍历当前节点所有的子节点
			List<Element> listElement=node.elements();//所有一级子节点的list
			int i=0;
			String labelValue="";
			for(Element e:listElement){//遍历所有一级子节点
				if(e.getName().equals("cell")) {
					i++;
					
					if(i==1) {
						labelValue=labelValue+"【类型】"+e.getTextTrim();
						node.remove(e);
						continue;
					}
					if(i==2) {
						labelValue=labelValue+"【资源标识】"+e.getTextTrim();
						node.addAttribute("label", labelValue);
						labelValue="";
						node.remove(e);
						continue;
					}
					node.remove(e);
					continue;
				}
				this.getNodes(e);//递归
			}
		}
		 public void writeXml(Document document, String filePath) throws IOException {  
		        File xmlFile = new File("src/ningmengchang.xml");  
		        XMLWriter writer = null;  
		        try {
		            if (xmlFile.exists())  
		                xmlFile.delete();  
		            writer = new XMLWriter(new FileOutputStream(xmlFile), OutputFormat.createPrettyPrint());  
		            writer.write(document);  
		            writer.close();  
		        } catch (UnsupportedEncodingException e) {  
		            e.printStackTrace();  
		        } catch (FileNotFoundException e) {  
		            e.printStackTrace();  
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        } finally {  
		            if (writer != null)  
		                writer.close();  
		        } 
		 }
}
