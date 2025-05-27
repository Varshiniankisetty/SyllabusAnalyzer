package com.example.syllabusAnalyzer.Controller;

import com.example.syllabusAnalyzer.progress.ProgressHistory;
import com.example.syllabusAnalyzer.service.ProgressHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/progress-history")
public class ProgressHistoryController {

    @Autowired
    private ProgressHistoryService progressHistoryService;

    // Get all progress history records
    @GetMapping
    public ResponseEntity<List<ProgressHistory>> getAllProgressHistories() {
        List<ProgressHistory> histories = progressHistoryService.getAllProgressHistories();
        return ResponseEntity.ok(histories);
    }

    // Get a single progress history by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getProgressHistoryById(@PathVariable Integer id) {
        Optional<ProgressHistory> history = progressHistoryService.getProgressHistoryById(id);
        return history.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new progress history record
    @PostMapping
    public ResponseEntity<ProgressHistory> createProgressHistory(@RequestBody ProgressHistory history) {
        ProgressHistory savedHistory = progressHistoryService.saveProgressHistory(history);
        return ResponseEntity.ok(savedHistory);
    }

    // Update an existing progress history record
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProgressHistory(@PathVariable Integer id, @RequestBody ProgressHistory updatedHistory) {
        Optional<ProgressHistory> existingHistoryOpt = progressHistoryService.getProgressHistoryById(id);
        if (existingHistoryOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ProgressHistory existingHistory = existingHistoryOpt.get();
        // Update fields
        existingHistory.setUser(updatedHistory.getUser());
        existingHistory.setTopic(updatedHistory.getTopic());
        existingHistory.setDate(updatedHistory.getDate());
        existingHistory.setCompletedSubtopics(updatedHistory.getCompletedSubtopics());
        existingHistory.setTotalSubtopics(updatedHistory.getTotalSubtopics());

        ProgressHistory saved = progressHistoryService.saveProgressHistory(existingHistory);
        return ResponseEntity.ok(saved);
    }

    // Delete a progress history record
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProgressHistory(@PathVariable Integer id) {
        if (progressHistoryService.getProgressHistoryById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        progressHistoryService.deleteProgressHistory(id);
        return ResponseEntity.noContent().build();
    }
}
