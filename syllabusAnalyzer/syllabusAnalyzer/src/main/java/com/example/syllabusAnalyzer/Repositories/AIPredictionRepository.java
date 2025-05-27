package com.example.syllabusAnalyzer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.syllabusAnalyzer.ai.AIPrediction;

@Repository
public interface AIPredictionRepository extends JpaRepository<AIPrediction, Integer> {
    // Custom query methods can go here if needed
}
