package test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.sun.glass.ui.TouchInputSupport;


public class test {
 @Test
 /*public void test() {
	 Map param  = new HashMap();
     Map sysParam = new HashMap();

     sysParam.put("flowId","722");
     sysParam.put("orderId","12778131");
     sysParam.put("tacheId","9501002523");
     sysParam.put("orderCode","XJ-722-180517-10027");
     sysParam.put("medthodDesc","数据网调整-资源汇总");
     sysParam.put("compId","1");

     Map [] bizMap = new HashMap[2];
     Map biz1 = new HashMap();
     biz1.put("_recordId","1259396");
     biz1.put("prodId","");
     biz1.put("disSeq","newSEQ1258102");
     biz1.put("groupId","301");
     biz1.put("busiCircuitName","");
     Map biz2 = new HashMap();
     biz2.put("_recordId","1259397");
     biz2.put("prodId","");
     biz2.put("disSeq","newSEQ1258103");
     biz2.put("groupId","301");
     biz2.put("busiCircuitName","");
     bizMap[0] = biz1;
     bizMap[1] = biz2;

     param.put("SysParam",sysParam);
     param.put("BizParam",bizMap);
     
     
	 Map[] BizParam =param.get("BizParam") == null? null:(Map[])param.get("BizParam");
	 Map SysParam=param.get("SysParam") == null? null:(Map)param.get("SysParam");

	 String orderCode =SysParam.get("orderCode") == null ? "":(String)SysParam.get("orderCode");  	   

	 
	 for(int i=0;i<BizParam.length;i++){
			Map bizParamMap= BizParam[i];
	  	    System.out.println(bizParamMap.toString());

	  	    if(orderCode.split("-")[1].equals("722")) {
	  	    	String busiCircuitName=bizParamMap.get("busiCircuitName")==null?"":(String)bizParamMap.get("busiCircuitName");
	  	    	String prodInstId=bizParamMap.get("prodId")==null?"":(String)bizParamMap.get("prodId");
	  	    	String disSeq=bizParamMap.get("disSeq")==null?"":(String)bizParamMap.get("disSeq");
	  	    	if(busiCircuitName.equals("")&&prodInstId.equals("")) {
	  	    		bizParamMap.remove("prodId");
	  	    		bizParamMap.put("prodId", "newProdId"+disSeq);
	  	    	}
	  	    }
	  	    System.out.println(bizParamMap.toString());
	 }

   }
@Test
 public void test1() {
	 Map<String,Object> a1=new HashMap<String,Object>();
	 a1.put("a", "1");
	 Object a= (Object) a1;
	 Map<String,Integer> a2=(Map<String, Integer>) a;
	 System.out.println("1");
 }
 private void fuzhi(StringBuilder a) {
	// TODO Auto-generated method stub
	a.append("1");
}
 @Test
 public void testTemp() {//hashmap不虚无放重复的值，一个键只能有一个
//	    String a="1";
//	    System.out.println(a.length());
//	    String b=java.net.URLEncoder.encode(a);
//	    System.out.println(b.length());
	    Map<String,String> a=new HashMap<String,String>();
	    String a1="0";
	    putValue(a1);
	    System.out.println(a1.toString());
 }
 private void putValue(Map<String, String> a) {
	// TODO Auto-generated method stub
	a.put("1", "1");
}
 private void putValue(String a) {
	// TODO Auto-generated method stub
	a="2";
}
@Test*/
	public static void main(String[] args) {
	/*String bString=new String("ningmeng");
	String cString="ning"+"meng";
	String aString="ningmeng";

	System.out.println(aString==bString);
	System.out.println(aString==cString);
	System.out.println(aString==aString.intern());*/
	/*int a=4;
	if(a<5) {
		System.out.println('1');
	}
	else if(a<10) {
		System.out.println('2');
	}*/
	/*String a="a";
	if(!a.equals("a")) {
		System.out.println("1");
	}*/
	/* String aString="1";
	 String bString="2";
	 String cString="12";
	 String dString="1"+"2";
	 if(cString==dString) {
		 System.out.println("111");
	 }*/
	 test test=new test();
	 String table="RME_RES_UNION";
	 table=table.toLowerCase();
	 String[] names= table.split("_");
	 StringBuilder result=new StringBuilder(names[0]);
	 for(int i=1;i<names.length;i++) {
		 String temp=names[i];
		 temp=test.firstChaUpper(temp);
		 result.append(temp);
	 }
	 result.append("Schema.sql");
	 System.out.println(result.toString());
	 
}
 public String firstChaUpper(String test) {
	 String a="";
	 for(int i=0;i<test.length();i++) {
		 a=a+test.charAt(i);
		 if(i==0) {
			 a=a.toUpperCase();
		 }
	 }
	 return a;
 }
}
