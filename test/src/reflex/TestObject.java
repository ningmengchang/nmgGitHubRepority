package reflex;

import org.apache.xmlbeans.impl.jam.internal.elements.VoidClassImpl;

public class TestObject {
	private int a=1;
	private long b=2L;
	private String c="3";
	public TestObject() {
		
	}
	public TestObject(int a) {
	// TODO Auto-generated constructor stub
		System.out.println("int");
	}
	public TestObject(String c) {
		System.out.println("String");
	}
	public TestObject(long b) {
		System.out.println("long");
	}
	public String getC() {
		return c;
	}
	public int getA() {
		return a;
	}
	public void setA() {
		a=0;
	}
	public long getB() {
		return b;
	}
	public void setB() {
		b=0L;
	}
	public void setC() {
		c="0";
	}
}
