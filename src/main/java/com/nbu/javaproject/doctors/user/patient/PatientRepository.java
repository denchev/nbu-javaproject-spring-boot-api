package com.nbu.javaproject.doctors.user.patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByEgn(String egn);
}
