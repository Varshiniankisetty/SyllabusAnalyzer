package com.example.syllabusAnalyzer.Controller;

import com.example.syllabusAnalyzer.syllabus.SyllabusTopic;
import com.example.syllabusAnalyzer.service.SyllabusTopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/syllabus")
@CrossOrigin(origins = "http://localhost:4200")
public class SyllabusTopicController {

    @Autowired
    private SyllabusTopicService syllabusTopicService;

    @GetMapping("/all")
    public List<SyllabusTopic> getAllTopics() {
        return syllabusTopicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SyllabusTopic> getTopicById(@PathVariable Integer id) {
        return syllabusTopicService.getTopicById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/course/{courseId}")
    public List<SyllabusTopic> getTopicsByCourse(@PathVariable Integer courseId) {
        return syllabusTopicService.getTopicsByCourseId(courseId);
    }

    @PostMapping("/add")
    public ResponseEntity<SyllabusTopic> addTopic(@RequestBody SyllabusTopic topic) {
        SyllabusTopic savedTopic = syllabusTopicService.saveTopic(topic);
        return ResponseEntity.ok(savedTopic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SyllabusTopic> updateTopic(@PathVariable Integer id, @RequestBody SyllabusTopic topicDetails) {
        return syllabusTopicService.updateTopic(id, topicDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Integer id) {
        boolean deleted = syllabusTopicService.deleteTopic(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
