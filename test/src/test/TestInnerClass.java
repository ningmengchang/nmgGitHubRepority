package test;

import innerClass.OuterClass;
import innerClass.OuterClass.InnerClass;

public class TestInnerClass {
	public static void main(String[] args) {
		 OuterClass outerClass = new OuterClass();
	        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
	        innerClass.display();
	}
}
