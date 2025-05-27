package com.example.syllabusAnalyzer.service;

import com.example.syllabusAnalyzer.progress.ProgressHistory;
import com.example.syllabusAnalyzer.Repositories.ProgressHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressHistoryService {

    @Autowired
    private ProgressHistoryRepo progressHistoryRepo;

    public List<ProgressHistory> getAllProgressHistories() {
        return progressHistoryRepo.findAll();
    }

    public Optional<ProgressHistory> getProgressHistoryById(Integer id) {
        return progressHistoryRepo.findById(id);
    }

    public ProgressHistory saveProgressHistory(ProgressHistory history) {
        return progressHistoryRepo.save(history);
    }

    public void deleteProgressHistory(Integer id) {
        progressHistoryRepo.deleteById(id);
    }

    // Add more business logic methods as needed
}
