package Clone;

public class Student0 implements Cloneable {
    String name;// ��������
    int age;
    Professor0 p;// ѧ��1��ѧ��2������ֵ����һ���ġ�
 
    Student0(String name, int age, Professor0 p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }
 
    public Object clone() {
        Student0 o = null;
        try {
            o = (Student0) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        try {
			o.p = (Professor0) p.clone();//��������������
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return o;
    }
}
