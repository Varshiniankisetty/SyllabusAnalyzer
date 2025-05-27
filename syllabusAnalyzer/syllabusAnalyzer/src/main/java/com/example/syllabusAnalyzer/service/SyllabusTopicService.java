package com.example.syllabusAnalyzer.service;

import com.example.syllabusAnalyzer.syllabus.SyllabusTopic;
import com.example.syllabusAnalyzer.Repositories.SyllabusTopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SyllabusTopicService {

    @Autowired
    private SyllabusTopicRepo syllabusTopicRepo;

    public List<SyllabusTopic> getAllTopics() {
        return syllabusTopicRepo.findAll();
    }

    public Optional<SyllabusTopic> getTopicById(Integer id) {
        return syllabusTopicRepo.findById(id);
    }

    public SyllabusTopic saveTopic(SyllabusTopic topic) {
        return syllabusTopicRepo.save(topic);
    }

    public Optional<SyllabusTopic> updateTopic(Integer id, SyllabusTopic topicDetails) {
        return syllabusTopicRepo.findById(id).map(topic -> {
            topic.setTopicName(topicDetails.getTopicName());
            topic.setOrderIndex(topicDetails.getOrderIndex());
            topic.setTotalSubtopics(topicDetails.getTotalSubtopics());
            topic.setCourse(topicDetails.getCourse());
            return syllabusTopicRepo.save(topic);
        });
    }

    public boolean deleteTopic(Integer id) {
        return syllabusTopicRepo.findById(id).map(topic -> {
            syllabusTopicRepo.delete(topic);
            return true;
        }).orElse(false);
    }

    public List<SyllabusTopic> getTopicsByCourseId(Integer courseId) {
        return syllabusTopicRepo.findByCourseCourseId(courseId);
    }
}
