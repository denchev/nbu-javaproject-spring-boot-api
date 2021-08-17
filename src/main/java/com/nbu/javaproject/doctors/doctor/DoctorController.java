package com.nbu.javaproject.doctors.doctor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    @PreAuthorize("!hasAuthority('USER')")
    List<Doctor> getDoctors() {
        List<Doctor> doctors = this.doctorService.getDoctors();
        if (doctors.size() == 0) {
            throw new EntityNotFoundException(Doctor.class.toString());
        }
        return doctors;
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public void login(@RequestBody DoctorCredentials credentials) {

    }
}
