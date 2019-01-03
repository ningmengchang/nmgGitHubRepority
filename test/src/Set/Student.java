package Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * HashSet�������,���ǲ���������ظ���Ԫ�أ�TreeSet������ģ�ʹ��treeSet��Ҫ����ʵ��Comparable�ӿڣ������ж϶���Ĵ�С��list��contains�ж�ͨ������equal
 */
/*
 * Set,set,HashSet,TreeSet
 */

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

public class Student implements Comparable<Student> {
    private String name;        // ����
    private int age;            // ����
 
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
 
    @Override
    public int compareTo(Student o) {//treeSet��treeMapʹ�ã�treeSet�ǹ��˵��ظ��ģ�treeMap�Ǹ����ظ��Ľ���ֵ��ԭ������ֵ��������
        return  this.age-o.age; // �Ƚ�����(���������)
    }
	@Override  
	public boolean equals(Object obj) { //list��containʹ��
		if(obj instanceof Student) //��ʼ��ֹ�豸����ʼ��ֹ�˿ڶ���ȵĻ�����ͬ��
			if(this.age==((Student)obj).age) {
				if(this.name.equals(((Student)obj).name)) {
					return true;
				}
			}
		return super.equals(obj);
	}
	@Override
	public int hashCode() {//hashMapʹ��
		return this.name.hashCode()+this.age;//�����ص�name��hashcode��age�ĺͣ���ʾhashcode����
	}
    @Test
    public static  void main(String[] args) {
    	Set<Student> set = new TreeSet<>();     // Java 7����ʯ�﷨(����������ļ������в���Ҫд����)//TreeSet�ķ�ֹ�ظ��Ĺ��������ǵײ�Ķ����compareTo
        set.add(new Student("Hao LUO", 33));
        set.add(new Student("Hao LUO", 33));
        set.add(new Student("XJ WANG", 32));
        set.add(new Student("Bruce LEE", 60));
        set.add(new Student("Bob YANG", 22));
                
        Set<Student> set1=new HashSet<>();//hashSet�ķ�ֹ�ظ��Ĺ��������ǵײ�Ķ����hashCode
        Student s= new Student("Hao LUO", 33);
        set1.add(new Student("Hao LUO", 33));
        set1.add(new Student("Hao LUO", 33));
        if(!set1.contains(new Student("Hao LUO", 33))) {
        }
        
        List<Student> list=new ArrayList<Student>();
        list.add(new Student("Hao LUO", 33));
        if(!list.contains(new Student("Hao LUO", 33))) {//ʵ����equal�����������ж�list��contains
        	list.add(new Student("Hao LUO", 33));
        }
        
        Map<Student,String> map=new TreeMap<Student,String>();//treemapҪ��ʵ����Comparable�ӿ�,�ظ���key�����ι��˵�
        map.put(new Student("Hao LUO", 33),"1");
        map.put(new Student("Hao LUO", 33),"2");
        map.put(new Student("XJ WANG", 32),"2");
        map.put(new Student("Bruce LEE", 60),"3");
        map.put(new Student("Bob YANG", 22),"4");

        Map<String,String> map1=new TreeMap<String,String>();//treemapҪ��ʵ����Comparable�ӿ�
        map1.put("4", "4");
        map1.put("4", "3");
        map1.put("5", "5");
        map1.put("3", "3");


        for(Student stu : set) {
            System.out.println(stu);
        }
        for(Entry<Student, String> entry:map.entrySet()) {
        	System.out.println(entry.getKey().toString()+":"+entry.getValue().toString());
        }
    }
 
}