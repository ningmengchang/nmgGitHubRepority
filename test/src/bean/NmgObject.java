package bean;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NmgObject {
	private Lock accountLock = new ReentrantLock();
	private String name;
	private String sex;
	
	public NmgObject(String name) {
		
	}
	public NmgObject() {
		
	}
	
	public  void setName(String name) {
		accountLock.lock();
		this.name=name;
		try {
			//wait(2000);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			accountLock.unlock();
		}
	}
	public  void setSex(String sex) {
		accountLock.lock();
		this.sex=sex;
		accountLock.unlock();
	}
	public String getName() {
		return this.name;
	}
	public String getSex() {
		return this.sex;
	}

}
