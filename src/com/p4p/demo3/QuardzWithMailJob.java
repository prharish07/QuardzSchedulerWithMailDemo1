package com.p4p.demo3;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.p4p.demo2.SendEmail;

public class QuardzWithMailJob {

	public static void main(String args[]) throws SchedulerException{
		
		JobDetail job1=JobBuilder.newJob(SendEmail.class).build();
		
		Trigger t1=TriggerBuilder.newTrigger().withIdentity("CornTriggerImp1").withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();
		
		//Trigger t1=TriggerBuilder.newTrigger().withIdentity("CornTriggerImp2").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(05).repeatForever()).build();
		
		Scheduler sc=StdSchedulerFactory.getDefaultScheduler();
		sc.start();
		sc.scheduleJob(job1, t1);
	}
}
