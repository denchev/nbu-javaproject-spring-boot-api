package com.nbu.javaproject.doctors.patient;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Long saveAndGetId(Patient patient) {
        this.patientRepository.save(patient);
        return this.patientRepository.findByEgn(patient.getEgn()).getId();
    }

    public Patient getPatientById(Long id) {
        return this.patientRepository.findById(id).orElseThrow(() -> new IllegalStateException("Patient with this id " + id + " does not exists."));
    }

    public Patient getPatientByEgn(String egn) {
        return this.patientRepository.findByEgn(egn);
    }

    public Patient createPatient(Patient patient) {
        // Patient does not have an idea - create a record for it
        if (patient.getId() == null) {
            try {
                Long patientId = this.saveAndGetId(patient);
                patient.setId(patientId);
                return patient;
            } catch (Exception exception) {
                // Patient already exists
                return this.getPatientByEgn(patient.getEgn());
            }
        }

        throw new IllegalStateException("Unable to create/find patient with this data");
    }
}
