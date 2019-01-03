package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler{

private Object targetObject;//��Ҫ�����Ŀ�����    
    
    public Object newProxy(Object targetObject) {//��Ŀ���������д���    
        this.targetObject = targetObject;     
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),    
                targetObject.getClass().getInterfaces(), this);//���ش������    
    }    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)//invoke����    
            throws Throwable {    
        checkPopedom();//һ�����ǽ����߼�����ĺ�����������ط���ģ����Ȩ��    
        Object ret = null;      // ���÷����ķ���ֵ    
        ret  = method.invoke(targetObject, args);       //����invoke������ret�洢�÷����ķ���ֵ    
        return ret;    
    }    
    
    private void checkPopedom() {//ģ����Ȩ�޵�����    
        System.out.println(".:���Ȩ��  checkPopedom()!");    
    }    

}
