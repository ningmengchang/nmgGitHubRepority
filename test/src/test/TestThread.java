package test;
/*
 * 守护线程，main线程和test的区别，main结束默认是不会杀死子线程的，除非子线程设置为守护线程，test的结束的话会杀死子线程
 */
import org.junit.Test;

import bean.NmgObject;
import thread.Thread1;
import thread.Thread2;

public class TestThread {
	public static void main(String[] args) {
		NmgObject oprObject=new NmgObject();
		Thread1 thread1=new Thread1(oprObject);
		Thread thread1_1=new Thread(thread1);
		Thread2 thread2=new Thread2(oprObject);
		Thread thread2_2=new Thread(thread2);
		thread2_2.setDaemon(true);//设置为守护线程，主线程结束，子线程杀死
		thread1_1.setDaemon(true);//
		thread2_2.start();
		thread1_1.start();
		System.out.println("主线程");
	}
	@Test
	public void test() {
		NmgObject oprObject=new NmgObject();
		Thread1 thread1=new Thread1(oprObject);
		Thread thread1_1=new Thread(thread1);
		Thread2 thread2=new Thread2(oprObject);
		Thread thread2_2=new Thread(thread2);
		thread2_2.setDaemon(true);//设置为守护线程，主线程结束，子线程杀死
		thread1_1.setDaemon(true);//
		thread2_2.start();
		thread1_1.start();
		System.out.println("主线程");
	}
}
