package Enum;

public enum Factory {
    CIRCLE(new Circle(),"CIRCLE"),
    RECTANGLE(new Rectangle(),"RECTANGLE"),
    SQUARE(new Square(),"SQUARE");
    
    // ��Ա����  
    private Shape shape;  
    private String name;  
    
    // ��ͨ����  
    public static Shape getShape(String name) {  
        for (Factory c : Factory.values()) {  
            if (c.name == name) {  
                return c.shape;  
            }  
        }  
        return null;  
    } 
    // ���췽��  
    private Factory(Shape shape, String name) {  
        this.shape = shape;  
        this.name = name;  
    } 
    public String getName() {
        return name;
    }
    public Shape getShape() {
        return shape;
    }


    public void setShape(Shape shape) {
        this.shape = shape;
    }


    public void setName(String name) {
        this.name = name;
    } 
    public static void main(String[] args) {
    	Factory.getShape("CIRCLE").draw();
    	Factory.getShape("RECTANGLE").draw();
    	Factory.getShape("SQUARE").draw();
    }
}
