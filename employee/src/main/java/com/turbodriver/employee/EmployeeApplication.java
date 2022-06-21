package com.turbodriver.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.turbodriver.employee",
                "com.turbodriver.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.turbodriver.clients"
)
public class EmployeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }
}
