package com.medcenter.medcenterbackend;

import com.medcenter.medcenterbackend.service.DoctorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedCenterBackendApplication {

    private static final DoctorService doctorService = new DoctorService();

    public static void main(String[] args) {
        //SpringApplication.run(MedCenterBackendApplication.class, args);

        System.out.println("Welcome to my app");

        System.out.println(doctorService.listDoctors());
    }

}
