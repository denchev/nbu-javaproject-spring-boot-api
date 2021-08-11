package com.nbu.javaproject.doctors.appointment;

import com.nbu.javaproject.doctors.doctor.Doctor;
import com.nbu.javaproject.doctors.patient.Patient;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Table(
        name = "appointments",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"doctor_id", "patient_id", "date"})
        }
)
@Entity(name = "appointment")
public class Appointment {
    @Id
    @SequenceGenerator(
            name = "appointment_sequence",
            sequenceName = "appointment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private Timestamp date;

    public Appointment(Long id, Doctor doctor, Patient patient, Timestamp date) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public Appointment(Doctor doctor, Patient patient, Timestamp date) {
        this.doctor = doctor;
        this.patient = patient;
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctorId=" + doctor +
                ", patientId=" + patient +
                ", date=" + date +
                '}';
    }
}
