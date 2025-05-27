package com.example.syllabusAnalyzer.service;

import com.example.syllabusAnalyzer.notifications.Notification;
import com.example.syllabusAnalyzer.Repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Optional<Notification> getNotificationById(Integer id) {
        return notificationRepository.findById(id);
    }

    public List<Notification> getNotificationsForUser(Integer userId) {
        return notificationRepository.findByUserUserId(userId);
    }
}
