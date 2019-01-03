package test;

import static org.junit.Assert.assertTrue;

import java.util.List;
/*
 * ExecutorService£¬Executors£¬Ïß³Ì³Ø
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import bean.Accout;
import thread.AddMoneyThread;
 
public class Test01 { 
    public static void main(String[] args) {
        Accout account = new Accout();
        ExecutorService service = Executors.newFixedThreadPool(100);
 
        for(int i = 1; i <= 100; i++) {
            service.execute(new AddMoneyThread(account, 1));
        }
 
        service.shutdown();
        boolean switch1=true;
 
        while(!service.isTerminated()) {}
 
        System.out.println("ÕË»§Óà¶î: " + account.getBalance());
    }
}
