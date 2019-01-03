package quartz;
 
import java.util.Date;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
 
/**
 * created by Java-Road��job
 * created in 2018/5/26
 */
public class MyScheduler {
    public static void main(String[] args) throws SchedulerException {
        //����������Schedule
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
 
        //����JobDetailʵ��������HelloWordlJob���
        //����JobDetailʵ��������HelloWordlJob���
        JobDetail jobDetail = JobBuilder.newJob(HelloWorldJob.class).withIdentity("job1", "jobGroup1")
                .usingJobData("key1","this is jobDetail")
                .build();
        Date date1 = new Date();
        date1.setTime(date1.getTime() + 5000);
 
            //����ʱ��(10S��)
        Date date2 = new Date();
        date2.setTime(date2.getTime() + 10000);
        //����������Triggerʵ��(����ִ�У�ÿ��1Sִ��һ��)
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "triggerGroup1")
                .usingJobData("key2", "this is trigger")
                .startAt(date1)
                .endAt(date2)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();

 
        //��ʼִ��
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
    @Test
    public void testScheduler() throws SchedulerException {
    	//����������Schedule
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
 
        //����JobDetailʵ��������HelloWordlJob���
        JobDetail jobDetail = JobBuilder.newJob(HelloWorldJob.class).withIdentity("job1", "jobGroup1")
                .build();
 
        //����������Triggerʵ��(5S��ִ�У�10S�����)
            //��ʼʱ��(5S��)
        Date date1 = new Date();
        date1.setTime(date1.getTime() + 5000);
 
            //����ʱ��(10S��)
        Date date2 = new Date();
        date2.setTime(date2.getTime() + 10000);
 
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "triggerGroup1")
                .startAt(date1)
                .endAt(date2)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();
 
        //��ʼִ��
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

    }
}
