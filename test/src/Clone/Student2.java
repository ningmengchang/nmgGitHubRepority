package Clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;

public class Student2 implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    String name;// 常量对象。
    int age;
    Professor2 p;// 学生1和学生2的引用值都是一样的。
 
    Student2(String name, int age, Professor2 p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }
 
    public Object deepClone() throws IOException, OptionalDataException,
            ClassNotFoundException {
        // 将对象写到流里
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);
        // 从流里读出来
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (oi.readObject());
    }
 
}
