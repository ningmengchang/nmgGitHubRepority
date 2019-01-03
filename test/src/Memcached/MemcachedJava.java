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
	         // 连接本地的 Memcached 服务
	         MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
	         System.out.println("Connection to server sucessful.");
	      
	         // 存储数据
	         Future fo = mcc.set("ning", 900, "ningmengchang");
	      
	         // 查看存储状态
	         System.out.println("set status:" + fo.get());
	         
	         // 输出值
	         System.out.println("ning value in cache - " + mcc.get("ning"));
	         // 添加
	         fo = mcc.add("codingground", 900, "All Free Compilers");
	         
	         // 打印状态
	         System.out.println("add status:" + fo.get());
	         
	         // 输出
	         System.out.println("codingground value in cache - " + mcc.get("codingground"));
	 
	 
	         // 关闭连接
	         mcc.shutdown();
	         
	      }catch(Exception ex){
	         System.out.println( ex.getMessage() );
	      }
	   }
}
