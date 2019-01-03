package thread;

import bean.NmgObject;

public class Thread1 implements Runnable {
	private NmgObject threadObject;
	public Thread1(NmgObject nmg) {
		threadObject=nmg;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 System.out.println("这是我的线程1");
	}
}
