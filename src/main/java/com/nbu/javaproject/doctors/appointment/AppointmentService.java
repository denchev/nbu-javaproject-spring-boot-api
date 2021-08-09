package com.nbu.javaproject.doctors.appointment;

import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void save(Appointment appointment) {
        this.appointmentRepository.save(appointment);
    }
}
