package bean;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.security.auth.login.AccountLockedException;

/**
 * 银行账户
 * @author 骆昊
 *
 */
public class Accout {
	private Lock accountLock = new ReentrantLock();
    private double balance;     // 账户余额
 
    /**
     * 存款
     * @param money 存入金额
     */
    /*public synchronized void deposit(double money) {
        double newBalance = balance + money;
        try {
            Thread.sleep(10);   // 模拟此业务需要一段处理时间
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        balance = newBalance;
    }*/
    public void deposit(double money) {
    	accountLock.lock();
        try {
            double newBalance = balance + money;
            try {
                Thread.sleep(10); // 模拟此业务需要一段处理时间
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            balance = newBalance;
        }
        finally {
            accountLock.unlock();
        }
    }
 
    /**
     * 获得账户余额
     */
    public double getBalance() {
        return balance;
    }
}