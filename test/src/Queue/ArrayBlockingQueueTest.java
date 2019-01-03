package Queue;

import java.util.concurrent.ArrayBlockingQueue;
/**
 * 生产者，消费者。ArrayBlockingQueue，阻塞队列
 * @author ningm
 *
 */

public class ArrayBlockingQueueTest {
	private ArrayBlockingQueue<Object> queue;
	public ArrayBlockingQueueTest(ArrayBlockingQueue<Object> queue) {
		this.queue=queue;
	}
	/*
	 * 生产者
	 */
	class producer implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public void produce() throws InterruptedException{
			String a="生产";
			System.out.println(a);
			queue.put(a);//这里用add的话，队列满了直接抛出异常；用put，队列满了的话，放不进去
		}
	}
	/*
	 * 消费者
	 */
	class Consumer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public void consume() throws InterruptedException {
			String a=(String) queue.take();
			System.out.println("消费："+a);
		}	
	}
	public static void main(String[] args) {
		ArrayBlockingQueue<Object> queue=new ArrayBlockingQueue<>(10);
		new Thread(new ArrayBlockingQueueTest(queue).new producer()).start();
		new Thread(new ArrayBlockingQueueTest(queue).new producer()).start();
		new Thread(new ArrayBlockingQueueTest(queue).new producer()).start();

        new Thread(new ArrayBlockingQueueTest(queue).new Consumer()).start();
        new Thread(new ArrayBlockingQueueTest(queue).new Consumer()).start();
        new Thread(new ArrayBlockingQueueTest(queue).new Consumer()).start();
	}
}
