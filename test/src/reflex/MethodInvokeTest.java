package reflex;

import java.lang.reflect.Method;
/**
 * ���䷽������
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
