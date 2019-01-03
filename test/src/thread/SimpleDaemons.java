package thread;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class SimpleDaemons implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("run..");
            }
        } catch (InterruptedException e) {
        	System.out.println("sleep() interrupted");
        }
    }
    @Test
    public void test() {
        for(int i = 0; i < 5; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // Must call before start()
            daemon.start();
        }
        System.out.println("All daemons started");
        try {
            TimeUnit.MILLISECONDS.sleep(175);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
