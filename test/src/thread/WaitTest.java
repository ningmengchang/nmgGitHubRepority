package thread;

/*
 * wait,Wait
 */
 class ThreadA extends Thread{
	public ThreadA(String name) {
		super(name);
	}
	public void run() {
		synchronized (this) {
			try {						
				Thread.sleep(1000);	//	ʹ��ǰ������ 1 s��ȷ��������� t1.wait(); ִ��֮����ִ�� notify()
			} catch (Exception e) {
				e.printStackTrace();
			}			
			System.out.println(Thread.currentThread().getName()+" call notify()");
			// ���ѵ�ǰ��wait�߳�
			this.notify();
		}
	}
}
public class WaitTest {
	public static void main(String[] args) {
		ThreadA t1 = new ThreadA("t1");
		synchronized(t1) {
			try {
				// �������߳�t1��
				System.out.println(Thread.currentThread().getName()+" start t1");
				t1.start();
				// ���̵߳ȴ�t1ͨ��notify()���ѡ�
				System.out.println(Thread.currentThread().getName()+" wait()");
				t1.wait();  //  ����ʹt1�̵߳ȴ������ǵ�ǰִ��wait���̵߳ȴ�
				System.out.println(Thread.currentThread().getName()+" continue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"���߳�");
	}
}
