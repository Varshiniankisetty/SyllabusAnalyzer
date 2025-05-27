package com.example.syllabusAnalyzer.service;

import com.example.syllabusAnalyzer.courses.Course;
import com.example.syllabusAnalyzer.Repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    // Get course by ID
    public Optional<Course> getCourseById(Integer id) {
        return courseRepo.findById(id);
    }

    // Create a new course
    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    // Update existing course
    public Optional<Course> updateCourse(Integer id, Course courseDetails) {
        return courseRepo.findById(id).map(course -> {
            course.setCourseName(courseDetails.getCourseName());
            course.setDescription(courseDetails.getDescription());
            return courseRepo.save(course);
        });
    }

    // Delete a course
    public boolean deleteCourse(Integer id) {
        return courseRepo.findById(id).map(course -> {
            courseRepo.delete(course);
            return true;
        }).orElse(false);
    }
}
