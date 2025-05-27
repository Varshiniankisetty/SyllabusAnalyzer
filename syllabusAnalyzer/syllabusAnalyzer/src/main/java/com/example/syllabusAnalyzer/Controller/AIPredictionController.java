package com.example.syllabusAnalyzer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.syllabusAnalyzer.ai.AIPrediction;
import com.example.syllabusAnalyzer.service.AIPredictionService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/ai-predictions")
public class AIPredictionController {

    @Autowired
    private AIPredictionService aiPredictionService;

    @PostMapping
    public ResponseEntity<AIPrediction> createPrediction(@RequestBody AIPrediction prediction) {
        AIPrediction savedPrediction = aiPredictionService.savePrediction(prediction);
        return ResponseEntity.ok(savedPrediction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPrediction(@PathVariable Integer id) {
        return aiPredictionService.getPredictionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AIPrediction>> getAllPredictions() {
        return ResponseEntity.ok(aiPredictionService.getAllPredictions());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrediction(@PathVariable Integer id) {
        aiPredictionService.deletePrediction(id);
        return ResponseEntity.ok().build();
    }
}
