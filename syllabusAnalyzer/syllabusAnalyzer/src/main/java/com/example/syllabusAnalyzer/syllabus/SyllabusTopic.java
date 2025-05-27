package com.example.syllabusAnalyzer.syllabus;

import com.example.syllabusAnalyzer.courses.Course;
import jakarta.persistence.*;

@Entity
public class SyllabusTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer topicId;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    private String topicName;

    private int orderIndex;

    private int totalSubtopics;

    // Getters and setters
    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public int getTotalSubtopics() {
        return totalSubtopics;
    }

    public void setTotalSubtopics(int totalSubtopics) {
        this.totalSubtopics = totalSubtopics;
    }
}
