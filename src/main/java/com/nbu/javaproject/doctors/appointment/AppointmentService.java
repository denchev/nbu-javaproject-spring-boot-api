package com.nbu.javaproject.doctors.appointment;

import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void save(Appointment appointment) {
        // Check if there is similar appointment already
        Appointment similarAppointment = this.appointmentRepository.findByDoctorIdAndPatientId(appointment.getDoctor().getId(), appointment.getPatient().getId());

        if (similarAppointment != null) {
            throw new IllegalStateException("There is an appointment set for this doctor and this patient");
        }
        this.appointmentRepository.save(appointment);
    }
}
