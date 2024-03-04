package com.tlx.portal.controllers;
import com.tlx.portal.classes.Notification;
import com.tlx.portal.services.NotificationService;
import com.tlx.portal.shared.Response;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/portal/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        if (notifications.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        Notification notification = notificationService.getNotificationById(id);
            return new ResponseEntity<>(notification, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Response> addNotification(@Valid @RequestBody Notification notification) {
        try {
            notificationService.addNotification(notification);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new Response(LocalDateTime.now(), "Notification added successfully", HttpStatus.CREATED.value()));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new Response(LocalDateTime.now(), "Failed to add notification", HttpStatus.INTERNAL_SERVER_ERROR.value())
            );        }
    }
}


