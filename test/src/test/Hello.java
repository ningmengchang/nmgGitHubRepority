package test;
/**
 * ��ʼ��˳�򣬳�ʼ��˳�򣬾�̬�������������ж����˳��-��Ա�������������ж����˳��-���캯��-��������
 * ����������ʱ�������ĵ���˳���ǣ��ȳ�ʼ����̬��Ա���ȸ����ӣ�����ʼ�������Ա������Ȼ����ø��๹�������ٳ�ʼ���Լ���Ա����������������������
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
