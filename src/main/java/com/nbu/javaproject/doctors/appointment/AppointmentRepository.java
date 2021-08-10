package com.nbu.javaproject.doctors.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query(value = "SELECT * FROM appointments WHERE doctor_id = ?1 AND patient_id = ?2", nativeQuery = true)
    Appointment findByDoctorIdAndPatientId(Long doctorId, Long patientId);
}
