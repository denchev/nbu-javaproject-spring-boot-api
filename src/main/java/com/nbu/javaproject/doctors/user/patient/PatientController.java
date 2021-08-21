package com.nbu.javaproject.doctors.user.patient;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/patient")
public class PatientController {
    private final PatientService patientService;

    private final PasswordEncoder passwordEncoder;

    public PatientController(PatientService patientService, PasswordEncoder passwordEncoder) {
        this.patientService = patientService;
        this.passwordEncoder = passwordEncoder;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "auth")
    public void auth() {
        System.out.println("Authentication needs to happen");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "create")
    public Map<String, String> create(@RequestBody PatientRegistrationData patientData) {
        HashMap<String, String> response = new HashMap<String, String>();
        String password = passwordEncoder.encode(patientData.getPassword()); // Encode password
        Patient patient = new Patient(patientData.getFirstName(), patientData.getLastName(), false, patientData.getEgn(), password);
        try {
            this.patientService.createPatient(patient);
            response.put("Status", "OK");
            return response;
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
        }

        response.put("Status", "NOTOK");
        return response;
    }
}
