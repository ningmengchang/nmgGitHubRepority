package Clone;

public class ShallowCopy {
    public static void main(String[] args) {
        Professor0 p = new Professor0("wangwu", 50);
        Student0 s1 = new Student0("zhangsan", 18, p);
        Student0 s2 = (Student0) s1.clone();
        s2.p.name = "lisi";
        s2.p.age = 30;
        s2.name = "z";
        s2.age = 45;
        System.out.println("ѧ��s1��������" + s1.name + "\nѧ��s1���ڵ�������" + s1.p.name + "," + "\nѧ��s1���ڵ����" + s1.p.age);// ѧ��1�Ľ���
    }
}
