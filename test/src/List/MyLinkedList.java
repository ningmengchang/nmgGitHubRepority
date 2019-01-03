package List;

public  class MyLinkedList /*implements List<E>*/ {
	  private Node first;
	  private Node last;
	  private int size ;
	  
	  //����Ԫ��
	  public void add(Object obj) {
	    if (first == null) {
	      Node n = new Node(null,obj,null);
	      first = n;
	      last = n;
	    }else {
	      //ֱ����last�������µĽڵ�
	      Node n = new Node(last, obj, null);
	      last.setNext(n);
	      last = n;
	    }
	    size++;
	  }
	  
	  //��ȡԪ��
	  public Object get(int  index) throws Exception {
	    return getNode(index).getObj();
	  }
	  //ɾ��Ԫ��
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
	  //ָ��λ�ü���Ԫ��
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
	  //�滻�ڵ�
	  public boolean set(int index,Object obj) throws Exception{
	    boolean flag = false;
	    Node temp = getNode(index);
	    System.out.println("��ȡ�Ľڵ�" +temp.getObj()+temp.getPreview().getObj()+temp.getNext().getObj());
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
	     if (index  < (size >> 1)) {//�����ƶ�һλ���൱��/2
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
	    list.add(2, "�½ڵ�" );
	    list.set(4, "�滻");
	    for (int i = 0; i <list.size(); i++) {
	      System.out.println(list.get(i));
	    }
	  }
	}
	 
	//����һ���ڲ���������ʾһ���ڵ�
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
