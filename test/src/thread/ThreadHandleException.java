package thread;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.TimeUnit;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

public class ThreadHandleException {
	public static void main(String[] args) {
		Thread thread1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String aString= null;
				aString.toLowerCase();
				System.out.println(11);
			}
		});
		thread1.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println(e.toString());
			}
		});
		thread1.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
