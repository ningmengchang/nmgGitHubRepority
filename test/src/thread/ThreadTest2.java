package thread;

public class ThreadTest2 {
	 
	 
	 class ObjectService {
		private String uname;
		private String pwd;
		String lock=new String();
		public void setUserNamePassWord(String userName,String passWord){
			try {
				synchronized (lock) {
					System.out.println("thread name="+Thread.currentThread().getName()
							+" 进入代码快:"+System.currentTimeMillis());
					uname=userName;
					Thread.sleep(3000);
					pwd=passWord;
					System.out.println("thread name="+Thread.currentThread().getName()
							+" 进入代码快:"+System.currentTimeMillis()+"入参uname:"+uname+"入参pwd:"+pwd);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	 class ThreadA extends Thread {
		private ObjectService objectService;
	 
		public ThreadA(ObjectService objectService) {
			super();
			this.objectService = objectService;
		}
		@Override
		public void run() {
			objectService.setUserNamePassWord("a", "aa");
		}
	}
	 
	 class ThreadB extends Thread {
	 	private ObjectService objectService;
	  
	 	public ThreadB(ObjectService objectService) {
	 		super();
	 		this.objectService = objectService;
	 	}
	 	@Override
	 	public void run() {
	 		objectService.setUserNamePassWord("b", "bb");
	 	}
	 }
   public static void main(String[] args) {
	   ThreadTest2 test2=new ThreadTest2();
	   ThreadTest2.ObjectService objectService=test2.new ObjectService();
	   ThreadTest2.ThreadA threadA=test2.new ThreadA(objectService);
	   ThreadTest2.ThreadB threadB=test2.new ThreadB(objectService);
	   threadA.start();
	   threadB.start();

   }

}
