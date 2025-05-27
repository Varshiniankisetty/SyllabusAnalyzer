package com.example.syllabusAnalyzer.Repositories;

import com.example.syllabusAnalyzer.notifications.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByUserUserId(Integer userId);
}
