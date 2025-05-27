package com.example.syllabusAnalyzer.Repositories;

import com.example.syllabusAnalyzer.users.User_Details;
import com.example.syllabusAnalyzer.progress.UserProgress;
import com.example.syllabusAnalyzer.syllabus.SyllabusTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface UserProgressRepo extends JpaRepository<UserProgress, Integer> {
    Optional<UserProgress> findByUserAndTopic(User_Details user, SyllabusTopic topic);
    List<UserProgress> findByUser(User_Details user);
}
