package com.example.syllabusAnalyzer.Repositories;

import com.example.syllabusAnalyzer.syllabus.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    List<Material> findByTopicTopicId(Integer topicId);
}
