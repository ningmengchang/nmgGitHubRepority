package Clone;

public class Student0 implements Cloneable {
    String name;// 常量对象。
    int age;
    Professor0 p;// 学生1和学生2的引用值都是一样的。
 
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
			o.p = (Professor0) p.clone();//加上这里的是深拷贝
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return o;
    }
}
