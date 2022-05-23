package com.turbodriver.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    public Integer toEmployeeId;
    public String toEmployeeName;
    public String message;
}
