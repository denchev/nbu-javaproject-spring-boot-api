package com.nbu.javaproject.doctors.appointment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nbu.javaproject.doctors.doctor.DoctorService;
import com.nbu.javaproject.doctors.patient.Patient;
import com.nbu.javaproject.doctors.patient.PatientService;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    private Patient extractPatient(String payload) throws JsonProcessingException, IllegalStateException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(payload);

        JsonNode patientNode = jsonNode.get("patient");

        String firstName = patientNode.get("firstName").asText();
        String lastName = patientNode.get("lastName").asText();
        String egn = patientNode.get("egn").asText();
        Boolean isInsured = patientNode.get("isInsured").asBoolean();

        Patient patient = new Patient(firstName, lastName, isInsured, egn);

        return patient;
    }

    @PostMapping(path = "/book")
    @CrossOrigin(origins = "http://localhost:3000")
    public void bookAppointment(@RequestBody String payload) throws JsonProcessingException, IllegalStateException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(payload);

        Long doctorId = jsonNode.get("appointment").get("doctor").asLong();
        Timestamp date = Timestamp.valueOf(jsonNode.get("appointment").get("date").asText());

        Patient patient = this.extractPatient(payload);
        Patient activePatient = this.patientService.createPatient(patient);

        try {
            Appointment appointment = new Appointment(
                    this.doctorService.getDoctorById(doctorId),
                    activePatient,
                    date
            );
            this.appointmentService.save(appointment);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
