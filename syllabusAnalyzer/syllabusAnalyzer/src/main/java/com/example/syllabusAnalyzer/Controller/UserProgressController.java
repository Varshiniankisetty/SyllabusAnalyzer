package com.example.syllabusAnalyzer.Controller;

import com.example.syllabusAnalyzer.Repositories.UserRepo;
import com.example.syllabusAnalyzer.progress.UserProgress;
import com.example.syllabusAnalyzer.Repositories.SyllabusTopicRepo;
import com.example.syllabusAnalyzer.users.User_Details;
import com.example.syllabusAnalyzer.service.UserProgressService;
import com.example.syllabusAnalyzer.syllabus.SyllabusTopic;
import com.example.syllabusAnalyzer.progress.ProgressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = "http://localhost:4200")
public class UserProgressController {

    @Autowired
    private UserProgressService progressService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SyllabusTopicRepo topicRepo;

    @PostMapping("/update")
    public ResponseEntity<?> updateProgress(@RequestBody ProgressRequest request) {
        Optional<User_Details> userOpt = userRepo.findById(request.getUserId());
        Optional<SyllabusTopic> topicOpt = topicRepo.findById(request.getTopicId());

        if (userOpt.isEmpty() || topicOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid user or topic ID");
        }

        User_Details user = userOpt.get();
        SyllabusTopic topic = topicOpt.get();

        UserProgress progress = progressService.getProgress(user, topic)
                .orElse(new UserProgress());
        progress.setUser(user);
        progress.setTopic(topic);
        progress.setCompletedSubtopics(request.getCompletedSubtopics());
        progress.setTotalSubtopics(request.getTotalSubtopics());

        return ResponseEntity.ok(progressService.saveOrUpdateProgress(progress));
    }
}
