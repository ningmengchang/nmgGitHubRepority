package test;

public class AssertTest {
	public static void main(String[]args) {
		try {
			int a=1;
			assert(a<0);
			System.out.println("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
