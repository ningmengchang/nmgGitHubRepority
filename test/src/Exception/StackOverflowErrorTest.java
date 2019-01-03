package Exception;

import org.junit.Test;

class StackOverflowErrorTest {
	 
    public static void main(String[] args) {
        main(null);
    }
    @Test
    public void testStackOverflowError(int i) {//没有收敛条件，包 stackoverflowError错误
    	testStackOverflowError(1);
    }
    @Override
    protected void finalize(){
    	System.out.println("结束了gameover");
    }
}

