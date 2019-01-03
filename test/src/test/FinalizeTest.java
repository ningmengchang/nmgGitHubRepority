package test;

public class FinalizeTest {
	public String nmg;
	@Override
	protected void finalize(){
		System.out.println("gameOver");
	}
	public static void main(String[] args) {
		FinalizeTest f1=new FinalizeTest();
		f1=null;
		System.gc();
	}
}
