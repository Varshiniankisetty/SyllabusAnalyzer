package com.example.syllabusAnalyzer.progress;

public class ProgressRequest {
    private Integer userId;
    private Integer topicId;
    private int completedSubtopics;
    private int totalSubtopics;

    // Getters and Setters

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public int getCompletedSubtopics() {
        return completedSubtopics;
    }

    public void setCompletedSubtopics(int completedSubtopics) {
        this.completedSubtopics = completedSubtopics;
    }

    public int getTotalSubtopics() {
        return totalSubtopics;
    }

    public void setTotalSubtopics(int totalSubtopics) {
        this.totalSubtopics = totalSubtopics;
    }
}
