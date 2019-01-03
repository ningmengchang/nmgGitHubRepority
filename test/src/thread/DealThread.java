package thread;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;


public class DealThread implements Runnable {

	private boolean activeFlag = true;
	private LinkedBlockingQueue<Object> queue;
	private String threadName;// �߳�����
	@SuppressWarnings("unused")
	private int threadIndex;

	public DealThread(LinkedBlockingQueue<Object> queue,
			String dealMsgBeanName, int threadIndex) throws Exception {
		try{
			this.queue = queue;
			this.threadIndex = threadIndex;
			this.threadName = dealMsgBeanName + "�����߳�" + "[" + threadIndex + "]";
			System.out.println(this.threadName + "��ʼ����ʼ!");
			System.out.println(this.threadName + "��ʼ������!");
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(this.threadName + "��ʼ���쳣!");
			throw ex;
		}
	}
	public void run() {
		while(true) {
			String obj;
			try {
				obj = (String) this.queue.take();
				System.out.println("ִ�н����"+obj);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*String obj=this.threadIndex+"";*/
		}
	}
}

