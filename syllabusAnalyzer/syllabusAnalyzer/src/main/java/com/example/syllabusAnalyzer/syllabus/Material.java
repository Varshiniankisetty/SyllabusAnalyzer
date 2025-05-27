package com.example.syllabusAnalyzer.syllabus;
import com.example.syllabusAnalyzer.syllabus.MaterialType;
import jakarta.persistence.*;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer materialId;

    private String title;

    private String link;

    @Enumerated(EnumType.STRING)
    private MaterialType materialType = MaterialType.OTHER;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private SyllabusTopic topic;

    // Getters and setters
    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public SyllabusTopic getTopic() {
        return topic;
    }

    public void setTopic(SyllabusTopic topic) {
        this.topic = topic;
    }
}
