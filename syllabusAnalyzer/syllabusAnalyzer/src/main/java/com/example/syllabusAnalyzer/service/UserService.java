package com.example.syllabusAnalyzer.service;

import com.example.syllabusAnalyzer.Repositories.CourseRepo;
import com.example.syllabusAnalyzer.Repositories.UserRepo;
import com.example.syllabusAnalyzer.users.User_Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.syllabusAnalyzer.courses.Course;


import java.time.LocalDateTime;
import java.util.Optional;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    private CourseRepo courseRepository;


    // Create password encoder instance
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<User_Details> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public Optional<User_Details> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public Optional<User_Details> findById(Integer id) {
        return userRepo.findById(id);
    }

    public User_Details registerUser(User_Details user) {
        if (user.getPasswordHash() == null || user.getPasswordHash().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(user.getPasswordHash());
        user.setPasswordHash(hashedPassword);

        user.setCreatedAt(LocalDateTime.now());

        // Optionally set default role
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        return userRepo.save(user);
    }

    public Optional<User_Details> loginUser(String username, String password) {
        if (password == null || password.isEmpty()) {
            return Optional.empty();
        }

        Optional<User_Details> userOpt = userRepo.findByUsername(username);
        if (userOpt.isPresent()) {
            User_Details user = userOpt.get();
            // Check if raw password matches hashed password
            if (passwordEncoder.matches(password, user.getPasswordHash())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
    public Optional<User_Details> assignCoursesToUser(Integer userId, List<Integer> courseIds) {
        Optional<User_Details> userOpt = userRepo.findById(userId);
        if (userOpt.isEmpty()) {
            return Optional.empty();
        }

        User_Details user = userOpt.get();

        List<Course> courses = courseRepository.findAllById(courseIds);
        Set<Course> courseSet = new HashSet<>(courses);

        user.setSelectedCourses(courseSet);

        User_Details updatedUser = userRepo.save(user);
        return Optional.of(updatedUser);
    }
}
