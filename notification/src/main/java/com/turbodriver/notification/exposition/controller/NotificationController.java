package com.turbodriver.notification.exposition.controller;

import com.turbodriver.clients.notification.NotificationRequest;
import com.turbodriver.notification.service.NotificationService;
import com.turbodriver.notification.service.NotificationServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/notification")
public class NotificationController {
    private final NotificationServiceImpl notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification... {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
