package com.medcenter.medcenterbackend.service;

import com.medcenter.medcenterbackend.domain.Doctor;
import com.medcenter.medcenterbackend.repository.DoctorRepository;

import java.util.List;

public class DoctorService {

    private static final DoctorRepository docRepo = DoctorRepository.getInstance();

    public List<Doctor> listDoctors(){
        return docRepo.getDoctors();
    }
}
