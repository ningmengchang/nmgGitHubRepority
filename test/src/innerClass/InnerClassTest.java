package innerClass;

import innerClass.OuterClass.InnerClass;

public class InnerClassTest {
	public static void main(String[] args) {
		 OuterClass outerClass = new OuterClass();
	        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
	        innerClass.display();
	}
}
