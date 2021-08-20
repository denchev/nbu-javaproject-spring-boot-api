package com.nbu.javaproject.doctors.user.doctor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    public Optional<Doctor> findDoctorByUin(String uin) {
        Optional<Doctor> doctor = this.doctorRepository.findByUin(uin);

        return doctor;
    }
}
