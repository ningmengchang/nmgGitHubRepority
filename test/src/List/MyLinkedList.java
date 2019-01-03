package List;

public  class MyLinkedList /*implements List<E>*/ {
	  private Node first;
	  private Node last;
	  private int size ;
	  
	  //新增元素
	  public void add(Object obj) {
	    if (first == null) {
	      Node n = new Node(null,obj,null);
	      first = n;
	      last = n;
	    }else {
	      //直接往last后增加新的节点
	      Node n = new Node(last, obj, null);
	      last.setNext(n);
	      last = n;
	    }
	    size++;
	  }
	  
	  //获取元素
	  public Object get(int  index) throws Exception {
	    return getNode(index).getObj();
	  }
	  //删除元素
	  public boolean remove(int index) throws Exception {
	    boolean flag = false;
	    Node temp = getNode(index);
	    if (temp!=null) {
	      temp.getPreview().setNext(temp.getNext());
	      temp.getNext().setPreview(temp.getPreview());
	      size--;
	      flag = true;
	    }
	    return flag;
	  }
	  //指定位置加入元素
	  public boolean add(int index,Object obj) throws Exception {
	    boolean flag = false;
	    Node temp = getNode(index);
	    if (temp!=null) {
	      if (index == 0) {
	        Node n = new Node(null,obj,temp);
	        first = n;
	      }else {
	        Node n = new Node(temp.getPreview(),obj,temp);
	        temp.getPreview().setNext(n);
	        temp.setPreview(n);
	      }     
	      size++;
	      flag = true;
	    }
	    return flag;
	  }
	  //替换节点
	  public boolean set(int index,Object obj) throws Exception{
	    boolean flag = false;
	    Node temp = getNode(index);
	    System.out.println("获取的节点" +temp.getObj()+temp.getPreview().getObj()+temp.getNext().getObj());
	    if (temp!=null) {
	      
	      Node n = new Node(temp.getPreview(),obj,temp.getNext());
	      temp.getPreview().setNext(n);
	      temp.getNext().setPreview(n);
	      flag = true;
	    }
	    return flag;
	  }
	  public int size(){
	    return size;
	  }
	  
	  public void rangeCheck(int index) throws Exception {
	    if (index <0 || index > size) {
	      throw new Exception();
	    }
	  }
	  
	  public Node getNode(int index) throws Exception {
	    rangeCheck(index);
	    Node temp = null;
	    //if (first != null) {  
	      /*for (int i = 0; i < index; i++) {
	        temp = temp.getNext();
	      }*/
	      /*int i = 0;
	      while(temp.getNext() != null && i<index){
	        temp = temp.getNext();
	        i++;
	      }*/
	    //}
	     if (index  < (size >> 1)) {//向右移动一位，相当于/2
	              temp = first;
	              for (int i = 0; i < index; i++)
	                  temp = temp.getNext();
	              return temp;
	          } else {
	              temp = last;
	              for (int i = size - 1; i > index; i--)
	                 temp = temp.getPreview();
	              return temp;
	          }
	  }
	  public static void main(String[] args) throws Exception {
	    MyLinkedList list = new MyLinkedList();
	    list.add("a" );
	    list.add("b" );
	    list.add("c" );
	    list.add("d" );
	    list.add("e" );
	    list.add("f" );
	    System.out.println(list.size());
	    list.remove(3);
	    list.add(2, "新节点" );
	    list.set(4, "替换");
	    for (int i = 0; i <list.size(); i++) {
	      System.out.println(list.get(i));
	    }
	  }
	}
	 
	//定义一个内部类用来表示一个节点
	class  Node{
	  private Node preview;
	  private Object obj;
	  private Node next;
	  public Node() {
	    
	  }
	  public Node(Node preview, Object obj, Node next) {
	    this();
	    this.preview = preview;
	    this.obj = obj;
	    this.next = next;
	  }
	  public Node getPreview() {
	    return preview;
	  }
	  public void setPreview(Node preview) {
	    this.preview = preview;
	  }
	  public Object getObj() {
	    return obj ;
	  }
	  public void setObj(Object obj) {
	    this.obj = obj;
	  }
	  public Node getNext() {
	    return next;
	  }
	  public void setNext(Node next) {
	    this.next = next;
	  }
	}
