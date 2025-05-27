package com.example.syllabusAnalyzer.Repositories;

import com.example.syllabusAnalyzer.users.User_Details;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User_Details, Integer> {
    Optional<User_Details> findByUsername(String username);
    Optional<User_Details> findByEmail(String email);
}
