package test;

/*
 * 异常 Exception
 */
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
 
class Human {
 
    public static void main(String[] args) 
        throws Exception {
        try {
            try {
                throw new Sneeze();//一个异常只能被他和他的父类捕获
            } 
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } 
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}
