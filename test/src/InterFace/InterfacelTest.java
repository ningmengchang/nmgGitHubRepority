package InterFace;

import org.apache.xmlbeans.impl.jam.internal.elements.VoidClassImpl;

public class InterfacelTest {
	  public interface interfaceParent {
		  public void method1();
		  public void method2();
	  }
	  public class ParentClass implements interfaceParent{
		@Override
		public void method1() {
			// TODO Auto-generated method stub
			System.out.println("this is ParentClass  method1");
			this.method2();
		}
		@Override
		public void method2() {
			// TODO Auto-generated method stub
			System.out.println("this is ParentClass  method2");
		} 
	  }
	  public class ChildClass extends ParentClass{
		   @Override
			public void method1() {
				// TODO Auto-generated method stub
				System.out.println("this is ChildClass  method1");
				super.method1();
			}
			@Override
			public void method2() {
				// TODO Auto-generated method stub
				System.out.println("this is ChildClass  method2");
			} 
	  }
	  public  static void  main(String[] args) {
		  InterfacelTest i1=new InterfacelTest();
		  InterfacelTest.ChildClass class1= i1.new ChildClass();
		  class1.method1();
	  }
}
