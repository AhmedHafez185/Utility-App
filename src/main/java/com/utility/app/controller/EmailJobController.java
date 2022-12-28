package com.utility.app.controller;

import com.utility.app.jobs.payload.EmailRequest;
import com.utility.app.jobs.payload.EmailResponse;
import com.utility.app.jobs.service.EmailScheduleService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email/")
public class EmailJobController {

    @Autowired
    EmailScheduleService emailScheduleService;
    @PostMapping("schedule")
    public ResponseEntity<EmailResponse> scheduleEmail(@RequestBody EmailRequest emailRequest) throws SchedulerException {
        EmailResponse emailResponse = emailScheduleService.schedulerEmail(emailRequest);
        return ResponseEntity.ok(emailResponse);
    }

}
