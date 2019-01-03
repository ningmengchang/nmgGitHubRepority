package InterFace;

public class BImpl extends AImpl implements UserManager {
		@Override
		public void addUser(String id, String password) {
			// TODO Auto-generated method stub
			System.out.println("BImpl:addUser");
		}

		@Override
		public void delUser(String id) {
			// TODO Auto-generated method stub
			System.out.println("BImpl:delUser");

		}
}
