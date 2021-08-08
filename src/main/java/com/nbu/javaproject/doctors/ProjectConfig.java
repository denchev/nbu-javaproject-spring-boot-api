package com.nbu.javaproject.doctors;

import com.nbu.javaproject.doctors.doctor.Doctor;
import com.nbu.javaproject.doctors.doctor.DoctorRepository;
import com.nbu.javaproject.doctors.speciality.Speciality;
import com.nbu.javaproject.doctors.speciality.SpecialityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProjectConfig {
    @Bean
    CommandLineRunner commandLineRunner(DoctorRepository doctorRepository, SpecialityRepository specialityRepository) {
        return args -> {
            Speciality neurology = new Speciality("Neurology");
            Speciality urology = new Speciality("Urology");
            Speciality pediatrics = new Speciality("Pediatrics");

            specialityRepository.saveAll(List.of(neurology, urology, pediatrics));

            Doctor ivan = new Doctor("Ivan", "Ivanov", 2322323L, true, neurology);
            Doctor petar = new Doctor("Petar", "Simeonov", 98523242L, true, urology);
            Doctor magi = new Doctor("Magdalena", "Georgieva", 5723232L, false, pediatrics);
            Doctor geri = new Doctor("Gergana", "Kostova", 82323232L, true, neurology);

            doctorRepository.saveAll(List.of(ivan, petar, magi, geri));
        };
    }
}
