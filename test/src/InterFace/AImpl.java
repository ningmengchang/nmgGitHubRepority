package InterFace;

public class AImpl implements UserManager{

	@Override
	public void addUser(String id, String password) {
		// TODO Auto-generated method stub
		System.out.println("AImpl:addUser");
	}

	@Override
	public void delUser(String id) {
		// TODO Auto-generated method stub
		System.out.println("AImpl:delUser");

	}
	public static void main(String[] args) {
		UserManager AImpl=new AImpl();
		AImpl.addUser("0", "0");
		UserManager BImpl=new BImpl();
		BImpl.addUser("0", "0");
	}

}
