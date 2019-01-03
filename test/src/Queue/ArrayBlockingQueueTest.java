package Queue;

import java.util.concurrent.ArrayBlockingQueue;
/**
 * �����ߣ������ߡ�ArrayBlockingQueue����������
 * @author ningm
 *
 */

public class ArrayBlockingQueueTest {
	private ArrayBlockingQueue<Object> queue;
	public ArrayBlockingQueueTest(ArrayBlockingQueue<Object> queue) {
		this.queue=queue;
	}
	/*
	 * ������
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
			String a="����";
			System.out.println(a);
			queue.put(a);//������add�Ļ�����������ֱ���׳��쳣����put���������˵Ļ����Ų���ȥ
		}
	}
	/*
	 * ������
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
			System.out.println("���ѣ�"+a);
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
