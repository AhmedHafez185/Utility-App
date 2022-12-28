package com.utility.app.jobs.seheduler;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class EmailScheduler extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        System.out.println("Send Mail at "+new Date().toString() +" with Data : Subject : "+jobDataMap.get("subject")+" , Body"+jobDataMap.get("body"));
    }
}
