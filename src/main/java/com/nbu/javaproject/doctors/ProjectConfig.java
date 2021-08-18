package com.nbu.javaproject.doctors;

import com.nbu.javaproject.doctors.user.doctor.Doctor;
import com.nbu.javaproject.doctors.user.doctor.DoctorRepository;
import com.nbu.javaproject.doctors.speciality.Speciality;
import com.nbu.javaproject.doctors.speciality.SpecialityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class ProjectConfig {
    @Bean
    CommandLineRunner commandLineRunner(DoctorRepository doctorRepository, SpecialityRepository specialityRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Speciality neurology = new Speciality("Neurology");
            Speciality urology = new Speciality("Urology");
            Speciality pediatrics = new Speciality("Pediatrics");

            specialityRepository.saveAll(List.of(neurology, urology, pediatrics));

            String password = passwordEncoder.encode("test123");

            Doctor ivan =  new Doctor("Ivan", "Ivanov", "2322323", true, neurology, password);
            Doctor petar = new Doctor("Petar", "Simeonov", "98523242", true, urology, password);
            Doctor magi = new Doctor("Magdalena", "Georgieva", "5723232", false, pediatrics, password);
            Doctor geri = new Doctor("Gergana", "Kostova", "82323232", true, neurology, password);

            doctorRepository.saveAll(List.of(ivan, petar, magi, geri));
        };
    }
}
