package reflex;

import java.lang.reflect.Field;

import org.apache.xmlbeans.impl.jam.internal.elements.VoidClassImpl;

public class FieldTest {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		TestObject obj=new TestObject(0);
		Field c=TestObject.class.getDeclaredField("c");
		c.setAccessible(true);
		c.set(obj, "gggg");
		String read=obj.getC();
		System.out.println(read);
	}
}
