package com.turbodriver.notification.service;

import com.turbodriver.clients.notification.NotificationRequest;
import com.turbodriver.notification.model.Notification;
import com.turbodriver.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository notificationRepository;

    @Override
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toEmployeeId)
                        .toCustomerEmail(notificationRequest.toEmployeeName)
                        .sender("TurboDriver")
                        .message(notificationRequest.message)
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
