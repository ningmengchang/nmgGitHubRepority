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
        System.out.println( strTime + ":Hello World！");
 
        //获取DataMap数据方法一
        System.out.println("JobDetail JobDataMap:" + jobExecutionContext.getJobDetail().getJobDataMap().get("key1"));
        System.out.println("Trigger JobDataMap:" + jobExecutionContext.getTrigger().getJobDataMap().get("key2"));
 
        //获取DataMap数据方法二
        System.out.println("JobDataMap:" + jobExecutionContext.getMergedJobDataMap().get("key1"));
        System.out.println("JobDataMap:" + jobExecutionContext.getMergedJobDataMap().get("key2"));
 
        //获取数据方法三
        System.out.println("通过成员变量获取" + key1);
        System.out.println("通过成员变量获取" + key2);
    }
}

