package com.turbodriver.notification.service;

import com.turbodriver.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;


public interface NotificationService {
    void send(NotificationRequest notificationRequest);
}
