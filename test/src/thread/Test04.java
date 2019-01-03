package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
 * 生产者，消费者
 */
public class Test04 {
	public static void main(String[] args) throws InterruptedException {
		
		Queue buffer = new LinkedList<>();
		int maxSize = 10;
		Thread t1 = new Thread(new Producter(buffer, maxSize));
		Thread t3 = new Thread(new Producter(buffer, maxSize));
		Thread t2 = new Thread(new Customer(buffer, maxSize));
		Thread t4 = new Thread(new Customer(buffer, maxSize));
		t1.start();
		t2.start();
	}
}
 
class Producter implements Runnable {
	Queue buffer;
	int maxSize;
	public Producter(Queue buffer, int maxSize) {
		this.buffer = buffer;
		this.maxSize = maxSize;
	}
 
	@Override
	public void run() {
		while(true) {
			synchronized(buffer) {
				while(buffer.size() == maxSize) {
					System.out.println("队列已满,生产者线程暂停."+buffer.size());
					try {
						buffer.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Random random = new Random(); 
		        int i = random.nextInt(); 
			    System.out.println("Producing value : " + i + "-------size" + buffer.size()); 
			    buffer.add(i); 
			    buffer.notifyAll(); 
			}
		}
	}
}
 
class Customer implements Runnable {
	Queue buffer;
	int maxSize;
	public Customer(Queue buffer, int maxSize) {
		this.buffer = buffer;
		this.maxSize = maxSize;
	}
 
	@Override
	public void run() {
		while(true) {
			synchronized(buffer) {
				while(buffer.isEmpty()) {
					System.out.println("队列已空,消费者线程暂停."+buffer.size());
					try {
						buffer.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Consuming value : " + buffer.remove() + "-------size" + buffer.size()); 
				buffer.notifyAll(); 
			}
		}
	}
	
}

