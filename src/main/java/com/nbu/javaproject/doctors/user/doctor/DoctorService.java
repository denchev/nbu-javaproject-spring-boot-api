package com.nbu.javaproject.doctors.user.doctor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getDoctors() {
        return this.doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return this.doctorRepository.findById(id).orElseThrow(() -> new IllegalStateException("Doctor with this id " + id + " does not exists."));
    }
}
