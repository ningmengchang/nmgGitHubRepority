package quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloWorldJob implements Job {
    private String key1;
    private String key2;
 
    public String getKey1() {
        return key1;
    }
 
    public void setKey1(String key1) {
        this.key1 = key1;
    }
 
    public String getKey2() {
        return key2;
    }
 
    public void setKey2(String key2) {
        this.key2 = key2;
    }
 
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String strTime = new SimpleDateFormat("HH-mm-ss").format(new Date());
        System.out.println( strTime + ":Hello World��");
 
        //��ȡDataMap���ݷ���һ
        System.out.println("JobDetail JobDataMap:" + jobExecutionContext.getJobDetail().getJobDataMap().get("key1"));
        System.out.println("Trigger JobDataMap:" + jobExecutionContext.getTrigger().getJobDataMap().get("key2"));
 
        //��ȡDataMap���ݷ�����
        System.out.println("JobDataMap:" + jobExecutionContext.getMergedJobDataMap().get("key1"));
        System.out.println("JobDataMap:" + jobExecutionContext.getMergedJobDataMap().get("key2"));
 
        //��ȡ���ݷ�����
        System.out.println("ͨ����Ա������ȡ" + key1);
        System.out.println("ͨ����Ա������ȡ" + key2);
    }
}

