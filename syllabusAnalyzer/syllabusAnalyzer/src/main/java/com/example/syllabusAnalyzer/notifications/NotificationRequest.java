package com.example.syllabusAnalyzer.notifications;

public class NotificationRequest {
    private Integer userId;
    private String message;
    private Boolean isRead;

    // getters and setters
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Boolean getIsRead() {
        return isRead;
    }
    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }
}
