package reflex;

import java.lang.reflect.Method;
/**
 * 反射方法调用
 * @author nmc
 *
 */

class MethodInvokeTest {
 
    public static void main(String[] args) throws Exception {
        String str = "hello";
        Method m = str.getClass().getMethod("toUpperCase");
        System.out.println(m.invoke(str));  // HELLO
    }
}
