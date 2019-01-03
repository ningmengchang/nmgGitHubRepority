package innerClass;

public class StaticInnerClass {
    private String sex;
    public static String name = "chenssy";
    
    /**
     *��̬�ڲ���
     */
    static class InnerClass1{
        /* �ھ�̬�ڲ����п��Դ��ھ�̬��Ա */
        public static String _name1 = "chenssy_static";
        
        public void display(){
            /* 
             * ��̬�ڲ���ֻ�ܷ�����Χ��ľ�̬��Ա�����ͷ���
             * ���ܷ�����Χ��ķǾ�̬��Ա�����ͷ���
             */
            System.out.println("OutClass name :" + name);
        }
    }
    
    /**
     * �Ǿ�̬�ڲ���
     */
    class InnerClass2{
        /* �Ǿ�̬�ڲ����в��ܴ��ھ�̬��Ա */
        public String _name2 = "chenssy_inner";
        /* �Ǿ�̬�ڲ����п��Ե�����Χ����κγ�Ա,�����Ǿ�̬�Ļ��ǷǾ�̬�� */
        public void display(){
            System.out.println("OuterClass name��" + name);
        }
    }
    
    /**
     * @desc ��Χ�෽��
     * @author chenssy
     * @data 2013-10-25
     * @return void
     */
    public void display(){
        /* ��Χ����ʾ�̬�ڲ��ࣺ�ڲ���. */
        System.out.println(InnerClass1._name1);
        /* ��̬�ڲ��� ����ֱ�Ӵ���ʵ������Ҫ��������Χ�� */
        new InnerClass1().display();
        
        /* �Ǿ�̬�ڲ��Ĵ�����Ҫ��������Χ�� */
        StaticInnerClass.InnerClass2 inner2 = new StaticInnerClass().new InnerClass2();
        /* ��λ�Ǿ�̬�ڲ���ĳ�Ա��Ҫʹ�÷Ǿ�̬�ڲ����ʵ�� */
        System.out.println(inner2._name2);
        inner2.display();
    }
    
    public static void main(String[] args) {
    	StaticInnerClass outer = new StaticInnerClass();
        outer.display();
    }
}
