package com.example.syllabusAnalyzer.progress;

import com.example.syllabusAnalyzer.users.User_Details;
import com.example.syllabusAnalyzer.syllabus.SyllabusTopic;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ProgressHistory")
public class ProgressHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer historyId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User_Details user;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private SyllabusTopic topic;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "completed_subtopics", nullable = false)
    private int completedSubtopics;

    @Column(name = "total_subtopics", nullable = false)
    private int totalSubtopics;

    // Getters and Setters

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public User_Details getUser() {
        return user;
    }

    public void setUser(User_Details user) {
        this.user = user;
    }

    public SyllabusTopic getTopic() {
        return topic;
    }

    public void setTopic(SyllabusTopic topic) {
        this.topic = topic;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
