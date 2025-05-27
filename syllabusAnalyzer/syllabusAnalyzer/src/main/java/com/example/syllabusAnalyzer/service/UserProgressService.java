package com.example.syllabusAnalyzer.service;

import com.example.syllabusAnalyzer.users.User_Details;
import com.example.syllabusAnalyzer.Repositories.UserProgressRepo;
import com.example.syllabusAnalyzer.progress.UserProgress;
import com.example.syllabusAnalyzer.syllabus.SyllabusTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserProgressService {

    @Autowired
    private UserProgressRepo progressRepo;

    public Optional<UserProgress> getProgress(User_Details user, SyllabusTopic topic) {
        return progressRepo.findByUserAndTopic(user, topic);
    }

    public List<UserProgress> getAllProgressForUser(User_Details user) {
        return progressRepo.findByUser(user);
    }

    public UserProgress saveOrUpdateProgress(UserProgress progress) {
        progress.setLastUpdated(LocalDateTime.now());
        return progressRepo.save(progress);
    }
}
