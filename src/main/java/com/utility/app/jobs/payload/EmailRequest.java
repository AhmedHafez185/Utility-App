package com.utility.app.jobs.payload;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class EmailRequest {

    private String email;
    private String subject;

    private String body;

    private Date dateTime;

//    private ZoneId timeZone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

//    public ZoneId getTimeZone() {
//        return timeZone;
//    }
//
//    public void setTimeZone(ZoneId timeZone) {
//        this.timeZone = timeZone;
//    }
}

