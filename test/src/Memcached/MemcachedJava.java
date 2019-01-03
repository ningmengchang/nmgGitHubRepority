package Memcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;
/*
 * memcached,Memcached
 */
public class MemcachedJava {
	public static void main(String[] args) {
		   
	      try{
	         // ���ӱ��ص� Memcached ����
	         MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
	         System.out.println("Connection to server sucessful.");
	      
	         // �洢����
	         Future fo = mcc.set("ning", 900, "ningmengchang");
	      
	         // �鿴�洢״̬
	         System.out.println("set status:" + fo.get());
	         
	         // ���ֵ
	         System.out.println("ning value in cache - " + mcc.get("ning"));
	         // ���
	         fo = mcc.add("codingground", 900, "All Free Compilers");
	         
	         // ��ӡ״̬
	         System.out.println("add status:" + fo.get());
	         
	         // ���
	         System.out.println("codingground value in cache - " + mcc.get("codingground"));
	 
	 
	         // �ر�����
	         mcc.shutdown();
	         
	      }catch(Exception ex){
	         System.out.println( ex.getMessage() );
	      }
	   }
}
