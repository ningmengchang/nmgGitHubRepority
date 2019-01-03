package thread;

import bean.Accout;

/**
 * ��Ǯ�߳�
 * @author ���
 *
 */
public class AddMoneyThread implements Runnable {
    private Accout account;    // �����˻�
    private double money;       // ������
 
    public AddMoneyThread(Accout account, double money) {
        this.account = account;
        this.money = money;
    }
 
    @Override
    public void run() {
        account.deposit(money);
    }
 
}