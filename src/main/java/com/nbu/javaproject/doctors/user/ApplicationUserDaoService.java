package com.nbu.javaproject.doctors.user;

import com.nbu.javaproject.doctors.user.doctor.Doctor;
import com.nbu.javaproject.doctors.user.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("auth")
public class ApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    private final DoctorService doctorService;

    @Autowired
    public ApplicationUserDaoService(PasswordEncoder passwordEncoder, DoctorService doctorService) {
        this.passwordEncoder = passwordEncoder;
        this.doctorService = doctorService;
    }

    @Override
    public Optional<Doctor> selectApplicationUserByUsername(String username) {
        return doctorService.findDoctorByUin(username);
    }
}
