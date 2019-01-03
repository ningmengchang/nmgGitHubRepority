package reflex;

import org.junit.Test;

import bean.NmgObject;

public class reflexTest {
@Test
	public void test() throws InstantiationException, IllegalAccessException {
		try {
			String object=String.class.newInstance();//反射获取对象方式1
			System.out.println(object);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			NmgObject object1=(NmgObject) Class.forName("bean.NmgObject").newInstance();//反射获取对象方式2
			object1.setSex("男");
			System.out.println(object1.getSex());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ClassLoader c=Thread.currentThread().getContextClassLoader();//sun.misc.Launcher
		//	Class cc=ClassLoader.findLoadedClass("bean.NmgObject");
			NmgObject object1=(NmgObject)c.loadClass("bean.NmgObject").newInstance();//如果在web程序中，需要按照
			object1.setSex("男");
			System.out.println(object1.getSex());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ClassLoader c=reflexTest.class.getClassLoader();
			NmgObject object1=(NmgObject)c.loadClass("bean.NmgObject").newInstance();//如果在web程序中，需要按照
			object1.setSex("男");
			System.out.println(object1.getSex());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
private static Object newInstance(String s, ClassLoader classloader) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	Class class1 = null;
	if (classloader == null) {
		try {
			class1 = Class.forName(s);
		} catch (ClassNotFoundException e) {
			throw e;
		}
	} else {
		try {
			class1 = classloader.loadClass(s);
		} catch (ClassNotFoundException e) {
			throw e;
		}
	}

	Object o = null;
	try {
		o = class1.newInstance();
	} catch (InstantiationException e) {
		throw e;
	} catch (IllegalAccessException e) {
		throw e;
	}
	return o;

}
}
