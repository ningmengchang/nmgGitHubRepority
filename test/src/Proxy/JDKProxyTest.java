package Proxy;

import InterFace.UserManager;

public class JDKProxyTest {
	 class UserManageImpl implements UserManager{

		@Override
		public void addUser(String id, String password) {
			// TODO Auto-generated method stub
			System.out.println("method:addUser");
		}

		@Override
		public void delUser(String id) {
			// TODO Auto-generated method stub
			System.out.println("method:delUser");
		}
		
	}
	public static void main(String[] args) {
		JDKProxyTest jt=new JDKProxyTest();
		UserManageImpl ui=jt.new UserManageImpl();
		JDKProxy jp=new JDKProxy();
		UserManager prox=(UserManager) jp.newProxy(ui);
		prox.addUser("", "");
	}
}
