package Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * HashSet是无序的,但是不允许放入重复的元素，TreeSet是有序的，使用treeSet需要对象实现Comparable接口，用于判断对象的大小，list的contains判断通过对象equal
 */
/*
 * Set,set,HashSet,TreeSet
 */

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

public class Student implements Comparable<Student> {
    private String name;        // 姓名
    private int age;            // 年龄
 
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
 
    @Override
    public int compareTo(Student o) {//treeSet和treeMap使用，treeSet是过滤掉重复的，treeMap是更新重复的建的值，原来建的值不存在了
        return  this.age-o.age; // 比较年龄(年龄的升序)
    }
	@Override  
	public boolean equals(Object obj) { //list的contain使用
		if(obj instanceof Student) //起始终止设备和起始终止端口都相等的话是相同的
			if(this.age==((Student)obj).age) {
				if(this.name.equals(((Student)obj).name)) {
					return true;
				}
			}
		return super.equals(obj);
	}
	@Override
	public int hashCode() {//hashMap使用
		return this.name.hashCode()+this.age;//常量池的name的hashcode和age的和，表示hashcode方法
	}
    @Test
    public static  void main(String[] args) {
    	Set<Student> set = new TreeSet<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)//TreeSet的防止重复的过滤条件是底层的对象的compareTo
        set.add(new Student("Hao LUO", 33));
        set.add(new Student("Hao LUO", 33));
        set.add(new Student("XJ WANG", 32));
        set.add(new Student("Bruce LEE", 60));
        set.add(new Student("Bob YANG", 22));
                
        Set<Student> set1=new HashSet<>();//hashSet的防止重复的过滤条件是底层的对象的hashCode
        Student s= new Student("Hao LUO", 33);
        set1.add(new Student("Hao LUO", 33));
        set1.add(new Student("Hao LUO", 33));
        if(!set1.contains(new Student("Hao LUO", 33))) {
        }
        
        List<Student> list=new ArrayList<Student>();
        list.add(new Student("Hao LUO", 33));
        if(!list.contains(new Student("Hao LUO", 33))) {//实现了equal，可以用来判断list的contains
        	list.add(new Student("Hao LUO", 33));
        }
        
        Map<Student,String> map=new TreeMap<Student,String>();//treemap要求建实现了Comparable接口,重复的key会依次过滤掉
        map.put(new Student("Hao LUO", 33),"1");
        map.put(new Student("Hao LUO", 33),"2");
        map.put(new Student("XJ WANG", 32),"2");
        map.put(new Student("Bruce LEE", 60),"3");
        map.put(new Student("Bob YANG", 22),"4");

        Map<String,String> map1=new TreeMap<String,String>();//treemap要求建实现了Comparable接口
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