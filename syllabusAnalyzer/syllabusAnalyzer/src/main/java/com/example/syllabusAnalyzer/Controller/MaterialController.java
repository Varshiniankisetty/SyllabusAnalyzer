package com.example.syllabusAnalyzer.Controller;

import com.example.syllabusAnalyzer.syllabus.Material;
import com.example.syllabusAnalyzer.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/materials")
@CrossOrigin(origins = "http://localhost:4200") // Modify based on frontend port
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/topic/{topicId}")
    public ResponseEntity<List<Material>> getMaterialsByTopic(@PathVariable Integer topicId) {
        List<Material> materials = materialService.getMaterialsByTopicId(topicId);
        return ResponseEntity.ok(materials);
    }

    @PostMapping("/add")
    public ResponseEntity<Material> addMaterial(@RequestBody Material material) {
        Material saved = materialService.saveMaterial(material);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Integer id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }
}
