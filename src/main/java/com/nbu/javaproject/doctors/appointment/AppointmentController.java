package com.nbu.javaproject.doctors.appointment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nbu.javaproject.doctors.doctor.DoctorService;
import com.nbu.javaproject.doctors.patient.Patient;
import com.nbu.javaproject.doctors.patient.PatientService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "api/v1/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final DoctorService doctorService;

    public AppointmentController(AppointmentService appointmentService, PatientService patientService, DoctorService doctorService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @PostMapping(path = "/book")
    @CrossOrigin(origins = "http://localhost:3000")
    public void bookAppointment(@RequestBody String payload) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(payload);

        Long doctorId = jsonNode.get("appointment").get("doctor").asLong();

        String patientFirstName = jsonNode.get("patient").get("firstName").asText();
        String patientLastName = jsonNode.get("patient").get("lastName").asText();
        String patientEgn = jsonNode.get("patient").get("egn").asText();
        Boolean patientIsInsured = jsonNode.get("patient").get("isInsured").asBoolean();

        Patient patient = new Patient(patientFirstName, patientLastName, patientIsInsured, patientEgn);
        Long patientId = this.patientService.save(patient);

        try {
            Appointment appointment = new Appointment(
                    this.doctorService.getDoctorById(doctorId),
                    this.patientService.getPatientById(patientId),
                    LocalDate.of(2021, 8, 8)
            );
            this.appointmentService.save(appointment);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
