package bean;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SimpleObject {
	private String name;
	private int id;
	public SimpleObject() {
		super();
	}
	public SimpleObject(String name,int id) {
		this.name=name;
		this.id=id;
	}
	public String getName() {
		return this.name;
	}
	public int getId() {
		return this.id;
	}
	@Override
	public boolean equals(Object obj) { 
		if(obj instanceof SimpleObject)
			if(this.name.equals(((SimpleObject)obj).getName()))
				if(this.id==((SimpleObject)obj).getId())
					return true;
		return super.equals(obj);
	}
	@Test
	public void test() {
		SimpleObject id=new SimpleObject("1",1);
		SimpleObject id2=new SimpleObject("1",1);
		List<SimpleObject> ids=new ArrayList<SimpleObject>();
		ids.add(id);
		if(!ids.contains(id2)) {
			ids.add(id2);
		}
		System.out.println("right");
	}
}
