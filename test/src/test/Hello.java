package test;
/**
 * 初始化顺序，初始化顺序，静态变量（按照类中定义的顺序）-成员变量（按照类中定义的顺序）-构造函数-其他方法
 * 。创建对象时构造器的调用顺序是：先初始化静态成员（先父后子），初始化父类成员变量，然后调用父类构造器，再初始化自己成员变量，最后调用自身构造器。
 * @author ningm
 *
 */
class A {
	
    static {
        System.out.print("1");
    }
 
    public A() {
        System.out.print("2");
    }
    {
		System.out.print("A");
	}
}
 
class B extends A{
	
    static {
        System.out.print("a");
    }
 
    public B() {
        System.out.print("b");
    }
    {
		System.out.print("B");
	}
}
 
public class Hello {
 
    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
    }
 
}
