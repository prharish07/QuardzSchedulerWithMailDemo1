package com.p4p.demo1;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuardzSimpleTriggerMain {
	public static void main(String args[]) throws SchedulerException{
		//Define Our Job and tie it with our JOB Class.
		JobDetail job1=JobBuilder.newJob(QuardzJob.class).build();
		
		Trigger t1=TriggerBuilder.newTrigger().withIdentity("SimpleTriggerImp").startNow().build();
		
		Scheduler sc=StdSchedulerFactory.getDefaultScheduler();
		sc.start();
		sc.scheduleJob(job1, t1);
		
		
	}

}
