package com.example.syllabusAnalyzer.Controller;

import com.example.syllabusAnalyzer.notifications.Notification;
import com.example.syllabusAnalyzer.notifications.NotificationRequest;
import com.example.syllabusAnalyzer.service.NotificationService;
import com.example.syllabusAnalyzer.service.UserService;
import com.example.syllabusAnalyzer.users.User_Details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final UserService userService;

    @Autowired
    public NotificationController(NotificationService notificationService, UserService userService) {
        this.notificationService = notificationService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody NotificationRequest request) {
        Optional<User_Details> userOpt = userService.findById(request.getUserId());
        if (!userOpt.isPresent()) {
            return ResponseEntity.status(404).body(null);
        }

        Notification notification = new Notification();
        notification.setUser(userOpt.get());
        notification.setMessage(request.getMessage());
        notification.setIsRead(request.getIsRead() != null ? request.getIsRead() : false);

        Notification saved = notificationService.saveNotification(notification);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotification(@PathVariable Integer id) {
        return notificationService.getNotificationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable Integer userId) {
        List<Notification> notifications = notificationService.getNotificationsForUser(userId);
        return ResponseEntity.ok(notifications);
    }
}
