package thread;

import com.sun.javafx.webkit.ThemeClientImpl;

import bean.NmgObject;

public class ThreadTest {
	 class Thread1 implements Runnable {
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
	 class Thread2 implements Runnable {
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
     public static void main(String[] args) throws InterruptedException {
    	 ThreadTest test=new ThreadTest();
    	 Thread thread1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<100;i++) {
	 				 System.out.println("这是我的线程1");
				}
			}
		});
    	 Thread thread2=new Thread(new Runnable() {
 			
 			@Override
 			public void run() {
 				// TODO Auto-generated method stub
 				for(int i=0;i<100;i++) {
 	 				 System.out.println("这是我的线程2");
 				}
 			}
 		});
    	 thread1.start();
    	 thread2.start(); 	
    	 Thread.sleep(5000);
     }
}
