package Queue;
/*
 * 阻塞队列，LinkedBlockingQueue
 */
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBolckingQueueTest{
	class ThreadTest implements Runnable{
		private LinkedBlockingQueue<String> queue;
		
		public void queueAdd(String a) {
			queue.add(a);
		}
		
		public ThreadTest(LinkedBlockingQueue<String> queue) {
			this.queue=queue;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				String obj;
				try {
					obj = (String) this.queue.take();
					System.out.println("执行结果："+obj);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		LinkedBolckingQueueTest lt=new LinkedBolckingQueueTest();
		LinkedBlockingQueue<String> queue=new LinkedBlockingQueue<String>(3);
		String a="线程执行结果";
		ThreadTest t1=lt.new ThreadTest(queue);
		Thread thread1=new Thread(t1);
		
		String[] param= {"1","2","3"};
		for(int i=0;i<param.length;i++) {
			queue.add(param[i]);
		}
		thread1.start();
		TimeUnit.SECONDS.sleep(3);
		queue.add("4");
	}

}
