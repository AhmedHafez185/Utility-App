package com.utility.app.jobs.payload;

public class EmailResponse {
    private boolean success;
    private String jobId;
    private String groupName;
    private String message;

    public EmailResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public EmailResponse(boolean success, String jobId, String groupName, String message) {
        this.success = success;
        this.jobId = jobId;
        this.groupName = groupName;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

