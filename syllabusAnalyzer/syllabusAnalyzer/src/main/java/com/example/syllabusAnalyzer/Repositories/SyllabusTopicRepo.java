package com.example.syllabusAnalyzer.Repositories;

import com.example.syllabusAnalyzer.syllabus.SyllabusTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SyllabusTopicRepo extends JpaRepository<SyllabusTopic, Integer> {
    List<SyllabusTopic> findByCourseCourseId(Integer courseId);
}
