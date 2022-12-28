package com.utility.app.jobs.service;

import com.utility.app.jobs.payload.EmailRequest;
import com.utility.app.jobs.payload.EmailResponse;
import com.utility.app.jobs.seheduler.EmailScheduler;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class EmailScheduleService {

    @Autowired
    private Scheduler scheduler;
    public EmailResponse schedulerEmail(EmailRequest emailRequest) throws SchedulerException {
//        ZonedDateTime dateTime = ZonedDateTime.of(emailRequest.getDateTime(), ZoneId.of("Africa/Cairo"));
        if(emailRequest.getDateTime().before(new Date())){
            EmailResponse emailResponse = new EmailResponse(false,"dateTime must be before current Time.");
            return emailResponse;
        }
        JobDetail jobDetail = buildJobDetail(emailRequest);
        Trigger trigger = buildTrigger(jobDetail,emailRequest.getDateTime());
        scheduler.scheduleJob(jobDetail,trigger);
        EmailResponse emailResponse = new EmailResponse(true,jobDetail.getKey().getName(),
                jobDetail.getKey().getGroup(),"Job Scheduled Successfully ..");
        System.out.println("Job Scheduled successfully...");
        return emailResponse;
    }
    private JobDetail buildJobDetail(EmailRequest emailRequest){
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("email",emailRequest.getEmail());
        jobDataMap.put("subject",emailRequest.getSubject());
        jobDataMap.put("body",emailRequest.getBody());
      return JobBuilder.newJob(EmailScheduler.class).withIdentity(UUID.randomUUID().toString(),"Email-Jobs").withDescription("Sending An Email Job").usingJobData(jobDataMap).storeDurably().build();
    }
    private Trigger buildTrigger(JobDetail jobDetail, Date startAt){
        return TriggerBuilder.newTrigger().forJob(jobDetail).withIdentity(jobDetail.getKey().getName(),"Email-Jobs")
                .withDescription("Send Mail Trigger").startAt(startAt).
                withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow()).build();
    }
}
