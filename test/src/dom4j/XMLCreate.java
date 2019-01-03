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
	     Element root = document.addElement("rows");//���ڵ�
	     root.addAttribute("id", "0");
	     
	     Element parmentRow=root.addElement("row");//��һ���ڵ�
	     parmentRow.addAttribute("id", prodId);
	     
	     
	     //����cell�ڵ�
	     for(int i=0;i<length;i++) {//���ڵ������
	    	 if(i==0) {
	    		 parmentRow.addElement("cell").setText(prodId);
	    		 continue;
	    	 }
	    	parmentRow.addElement("cell");
	     }
	     
	     for(int i=0;i<subLength;i++) {//�����ӽڵ�
	    	Element subElement= parmentRow.addElement("row");
	    	subElement.addAttribute("id",prodId+"_"+i);
	    	for(int j=0;j<length;j++) {
	    		subElement.addElement("cell").setText("1");
	    	}
	     }
	     
	     System.out.println(document.asXML());
	}

}
