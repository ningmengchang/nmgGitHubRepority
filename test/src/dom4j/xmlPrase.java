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
	    Document document=saxReader.read(inputXml);       //SAX���ɺͽ���XML�ĵ�
	    Element employees = document.getRootElement();    //��ø��ڵ�
	    getNodes(employees);
	    writeXml(document,"");
	}
	 public void parserXml(String fileName) {
	        File inputXml = new File(fileName);
	        SAXReader saxReader = new SAXReader();
	        try {
	            Document document=saxReader.read(inputXml);       //SAX���ɺͽ���XML�ĵ�
	            Element employees = document.getRootElement();    //��ø��ڵ�
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
		 * ��ָ���ڵ㿪ʼ,�ݹ���������ӽڵ�
		 * @author chenleixing
		 */
		public void getNodes(Element node){
			System.out.println("--------------------");
			
			//��ǰ�ڵ�����ơ��ı����ݺ�����
			System.out.println("��ǰ�ڵ����ƣ�"+node.getName());//��ǰ�ڵ�����
			System.out.println("��ǰ�ڵ�����ݣ�"+node.getTextTrim());//��ǰ�ڵ�����
			List<Attribute> listAttr=node.attributes();//��ǰ�ڵ���������Ե�list
			for(Attribute attr:listAttr){//������ǰ�ڵ����������
				String name=attr.getName();//��������
				String value=attr.getValue();//���Ե�ֵ
				System.out.println("�������ƣ�"+name+"����ֵ��"+value);
			}
			
			//�ݹ������ǰ�ڵ����е��ӽڵ�
			List<Element> listElement=node.elements();//����һ���ӽڵ��list
			int i=0;
			String labelValue="";
			for(Element e:listElement){//��������һ���ӽڵ�
				if(e.getName().equals("cell")) {
					i++;
					
					if(i==1) {
						labelValue=labelValue+"�����͡�"+e.getTextTrim();
						node.remove(e);
						continue;
					}
					if(i==2) {
						labelValue=labelValue+"����Դ��ʶ��"+e.getTextTrim();
						node.addAttribute("label", labelValue);
						labelValue="";
						node.remove(e);
						continue;
					}
					node.remove(e);
					continue;
				}
				this.getNodes(e);//�ݹ�
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
