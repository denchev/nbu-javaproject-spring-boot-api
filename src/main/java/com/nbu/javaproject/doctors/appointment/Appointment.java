package com.nbu.javaproject.doctors.appointment;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "appointment")
public class Appointment {
    @Id
    private Long id;
    private Long doctorId;
    private Long patientId;
    private LocalDate date;

    public Appointment(Long id, Long doctorId, Long patientId, LocalDate date) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
    }

    public Appointment(Long doctorId, Long patientId, LocalDate date) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
    }

    public Appointment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", date=" + date +
                '}';
    }
}
