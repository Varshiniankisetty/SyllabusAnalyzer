package com.example.syllabusAnalyzer.service;

import com.example.syllabusAnalyzer.syllabus.Material;
import com.example.syllabusAnalyzer.Repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> getMaterialsByTopicId(Integer topicId) {
        return materialRepository.findByTopicTopicId(topicId);
    }

    public Material saveMaterial(Material material) {
        return materialRepository.save(material);
    }

    public void deleteMaterial(Integer id) {
        materialRepository.deleteById(id);
    }
}
