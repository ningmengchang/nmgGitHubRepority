package reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.xmlbeans.impl.jam.internal.elements.VoidClassImpl;

import bean.NmgObject;
import junit.framework.Test;

public class ConstructorTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		int a=1;
		long b=1L;
		Object[] cString= {"3"};
		ConstructorTest constructorTest=new ConstructorTest();
		Constructor<?>[] constructors= TestObject.class.getConstructors();
		for(int i=0;i<constructors.length;i++) {
			Constructor<?> constructor=constructors[i];
			Class<?>[] classesType=constructor.getParameterTypes();
			for(int j=0;j<classesType.length;j++) {
				Class<?> classType=classesType[j];
				if(classType.equals(String.class)) {
					constructor.setAccessible(true);
					TestObject cObject=(TestObject)constructor.newInstance(cString);
					System.out.println(cObject.getC());
					
				}
			}
		}
		TestObject bObject=TestObject.class.newInstance();
		System.out.println(bObject.getC());
		/*Constructor<?>[] constructors=NmgObject.class.getConstructors();
		for(int i=0;i<constructors.length;i++) {
			Constructor<?> constructor=constructors[i];
			Class<?>[] classesType=constructor.getParameterTypes();
			for(int j=0;j<classesType.length;j++) {
				Class<?> classType=classesType[j];
				if(classType.equals(String.class)) {
					constructor.setAccessible(true);
					NmgObject aNmbject=(NmgObject)constructors[i].newInstance(new Object[] {"a"});
					break;
				}
			}
		}*/
	}
}
