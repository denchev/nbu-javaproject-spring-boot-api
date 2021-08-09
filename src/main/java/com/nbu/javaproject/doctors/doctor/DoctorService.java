package com.nbu.javaproject.doctors.doctor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getDoctors() {
        return this.doctorRepository.findAll();
    }
}
