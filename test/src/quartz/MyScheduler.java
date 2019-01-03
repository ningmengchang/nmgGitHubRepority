package quartz;
 
import java.util.Date;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
 
/**
 * created by Java-Road，job
 * created in 2018/5/26
 */
public class MyScheduler {
    public static void main(String[] args) throws SchedulerException {
        //创建调度器Schedule
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
 
        //创建JobDetail实例，并与HelloWordlJob类绑定
        //创建JobDetail实例，并与HelloWordlJob类绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloWorldJob.class).withIdentity("job1", "jobGroup1")
                .usingJobData("key1","this is jobDetail")
                .build();
        Date date1 = new Date();
        date1.setTime(date1.getTime() + 5000);
 
            //结束时间(10S后)
        Date date2 = new Date();
        date2.setTime(date2.getTime() + 10000);
        //创建触发器Trigger实例(立即执行，每隔1S执行一次)
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "triggerGroup1")
                .usingJobData("key2", "this is trigger")
                .startAt(date1)
                .endAt(date2)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();

 
        //开始执行
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
    @Test
    public void testScheduler() throws SchedulerException {
    	//创建调度器Schedule
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
 
        //创建JobDetail实例，并与HelloWordlJob类绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloWorldJob.class).withIdentity("job1", "jobGroup1")
                .build();
 
        //创建触发器Trigger实例(5S后执行，10S后结束)
            //开始时间(5S后)
        Date date1 = new Date();
        date1.setTime(date1.getTime() + 5000);
 
            //结束时间(10S后)
        Date date2 = new Date();
        date2.setTime(date2.getTime() + 10000);
 
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "triggerGroup1")
                .startAt(date1)
                .endAt(date2)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();
 
        //开始执行
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

    }
}
