package com.nbu.javaproject.doctors.appointment;

import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
}
