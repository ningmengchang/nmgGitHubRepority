package test;
/*
 * �ػ��̣߳�main�̺߳�test������main����Ĭ���ǲ���ɱ�����̵߳ģ��������߳�����Ϊ�ػ��̣߳�test�Ľ����Ļ���ɱ�����߳�
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
		thread2_2.setDaemon(true);//����Ϊ�ػ��̣߳����߳̽��������߳�ɱ��
		thread1_1.setDaemon(true);//
		thread2_2.start();
		thread1_1.start();
		System.out.println("���߳�");
	}
	@Test
	public void test() {
		NmgObject oprObject=new NmgObject();
		Thread1 thread1=new Thread1(oprObject);
		Thread thread1_1=new Thread(thread1);
		Thread2 thread2=new Thread2(oprObject);
		Thread thread2_2=new Thread(thread2);
		thread2_2.setDaemon(true);//����Ϊ�ػ��̣߳����߳̽��������߳�ɱ��
		thread1_1.setDaemon(true);//
		thread2_2.start();
		thread1_1.start();
		System.out.println("���߳�");
	}
}
