package dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XMLCreate {
	public static void main(String[] args) {
		 
		 String  prodId="123"; 
		 int length=12;
		 int subLength=4;
		
		 Document document = DocumentHelper.createDocument();
	     Element root = document.addElement("rows");//根节点
	     root.addAttribute("id", "0");
	     
	     Element parmentRow=root.addElement("row");//第一个节点
	     parmentRow.addAttribute("id", prodId);
	     
	     
	     //创建cell节点
	     for(int i=0;i<length;i++) {//父节点的属性
	    	 if(i==0) {
	    		 parmentRow.addElement("cell").setText(prodId);
	    		 continue;
	    	 }
	    	parmentRow.addElement("cell");
	     }
	     
	     for(int i=0;i<subLength;i++) {//设置子节点
	    	Element subElement= parmentRow.addElement("row");
	    	subElement.addAttribute("id",prodId+"_"+i);
	    	for(int j=0;j<length;j++) {
	    		subElement.addElement("cell").setText("1");
	    	}
	     }
	     
	     System.out.println(document.asXML());
	}

}
