package thread;

import bean.NmgObject;

public class Thread2 implements Runnable {
	private NmgObject threadObject;
	public Thread2(NmgObject nmg) {
		threadObject=nmg;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("�����ҵ��߳�2");
		//threadObject.setName("Thread2");
	}

}
