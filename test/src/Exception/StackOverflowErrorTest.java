package Exception;

import org.junit.Test;

class StackOverflowErrorTest {
	 
    public static void main(String[] args) {
        main(null);
    }
    @Test
    public void testStackOverflowError(int i) {//û�������������� stackoverflowError����
    	testStackOverflowError(1);
    }
    @Override
    protected void finalize(){
    	System.out.println("������gameover");
    }
}

