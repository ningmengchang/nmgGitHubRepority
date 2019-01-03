package thread;

import bean.Accout;

/**
 * 存钱线程
 * @author 骆昊
 *
 */
public class AddMoneyThread implements Runnable {
    private Accout account;    // 存入账户
    private double money;       // 存入金额
 
    public AddMoneyThread(Accout account, double money) {
        this.account = account;
        this.money = money;
    }
 
    @Override
    public void run() {
        account.deposit(money);
    }
 
}