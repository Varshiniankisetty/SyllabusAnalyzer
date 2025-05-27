package com.example.syllabusAnalyzer.Repositories;

import com.example.syllabusAnalyzer.courses.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
    // Custom queries can be added here if needed
}
