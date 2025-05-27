package com.example.syllabusAnalyzer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.syllabusAnalyzer.progress.ProgressHistory;

@Repository
public interface ProgressHistoryRepo extends JpaRepository<ProgressHistory, Integer> {
    // You can add custom queries here if needed
}
