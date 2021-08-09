package com.nbu.javaproject.doctors.patient;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Long save(Patient patient) {
        this.patientRepository.save(patient);
        return this.patientRepository.findByEgn(patient.getEgn()).getId();
    }

    public Patient getPatientById(Long id) {
        return this.patientRepository.findById(id).orElseThrow(() -> new IllegalStateException("Patient with this id " + id + " does not exists."));
    }
}
