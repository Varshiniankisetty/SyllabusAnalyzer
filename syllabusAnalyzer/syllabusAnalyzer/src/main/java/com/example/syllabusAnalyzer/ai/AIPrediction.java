package com.example.syllabusAnalyzer.ai;

import com.example.syllabusAnalyzer.users.User_Details;
import com.example.syllabusAnalyzer.syllabus.SyllabusTopic;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "AIPredictions")
public class AIPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer predictionId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User_Details user;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private SyllabusTopic topic;

    private LocalDate predictionDate;

    private float predictedCompletion;

    private int predictionHorizon; // days ahead predicted

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    // Getters and setters

    public Integer getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(Integer predictionId) {
        this.predictionId = predictionId;
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

    public LocalDate getPredictionDate() {
        return predictionDate;
    }

    public void setPredictionDate(LocalDate predictionDate) {
        this.predictionDate = predictionDate;
    }

    public float getPredictedCompletion() {
        return predictedCompletion;
    }

    public void setPredictedCompletion(float predictedCompletion) {
        this.predictedCompletion = predictedCompletion;
    }

    public int getPredictionHorizon() {
        return predictionHorizon;
    }

    public void setPredictionHorizon(int predictionHorizon) {
        this.predictionHorizon = predictionHorizon;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // No setter for createdAt because it's set by the DB
}
