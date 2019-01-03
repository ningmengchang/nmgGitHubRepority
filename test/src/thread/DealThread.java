package thread;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;


public class DealThread implements Runnable {

	private boolean activeFlag = true;
	private LinkedBlockingQueue<Object> queue;
	private String threadName;// 线程名称
	@SuppressWarnings("unused")
	private int threadIndex;

	public DealThread(LinkedBlockingQueue<Object> queue,
			String dealMsgBeanName, int threadIndex) throws Exception {
		try{
			this.queue = queue;
			this.threadIndex = threadIndex;
			this.threadName = dealMsgBeanName + "处理线程" + "[" + threadIndex + "]";
			System.out.println(this.threadName + "初始化开始!");
			System.out.println(this.threadName + "初始化结束!");
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(this.threadName + "初始化异常!");
			throw ex;
		}
	}
	public void run() {
		while(true) {
			String obj;
			try {
				obj = (String) this.queue.take();
				System.out.println("执行结果："+obj);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*String obj=this.threadIndex+"";*/
		}
	}
}

