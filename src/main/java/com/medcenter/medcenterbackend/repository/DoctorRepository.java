package com.medcenter.medcenterbackend.repository;

import com.medcenter.medcenterbackend.domain.Doctor;
import com.medcenter.medcenterbackend.domain.StaffType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DoctorRepository {
    private static DoctorRepository INSTANCE;
    private List<Doctor> doctors = new ArrayList<>();

    private DoctorRepository(){
        Doctor cardiologist = Doctor.builder()
                .id(1)
                .description("He is a great doctor")
                .specialization("cardiologist")
                .type(StaffType.DOCTOR)
                .age(25)
                .salary(100000L)
                .vacationDays(30.5d)
                .build();

        Doctor generalPracticeDoctor = Doctor.builder()
                .id(2)
                .description("He is a great general practice doctor")
                .specialization("general practice")
                .type(StaffType.DOCTOR)
                .age(25)
                .salary(100000L)
                .vacationDays(30.5d)
                .build();

        doctors.add(cardiologist);
        doctors.add(generalPracticeDoctor);
    }

    public synchronized static DoctorRepository getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DoctorRepository();
        }
        return INSTANCE;
    }



}
