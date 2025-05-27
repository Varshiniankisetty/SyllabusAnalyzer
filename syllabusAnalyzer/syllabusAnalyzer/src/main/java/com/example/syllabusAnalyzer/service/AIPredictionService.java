package com.example.syllabusAnalyzer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.syllabusAnalyzer.Repositories.AIPredictionRepository;
import com.example.syllabusAnalyzer.ai.AIPrediction;

import java.util.List;
import java.util.Optional;

@Service
public class AIPredictionService {

    private final AIPredictionRepository aiPredictionRepository;

    @Autowired
    public AIPredictionService(AIPredictionRepository aiPredictionRepository) {
        this.aiPredictionRepository = aiPredictionRepository;
    }

    public AIPrediction savePrediction(AIPrediction prediction) {
        return aiPredictionRepository.save(prediction);
    }

    public Optional<AIPrediction> getPredictionById(Integer id) {
        return aiPredictionRepository.findById(id);
    }

    public List<AIPrediction> getAllPredictions() {
        return aiPredictionRepository.findAll();
    }

    public void deletePrediction(Integer id) {
        aiPredictionRepository.deleteById(id);
    }
}
