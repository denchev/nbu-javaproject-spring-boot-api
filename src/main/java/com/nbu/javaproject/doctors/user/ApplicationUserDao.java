package com.nbu.javaproject.doctors.user;

import com.nbu.javaproject.doctors.user.doctor.Doctor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ApplicationUserDao {

    public Optional<Doctor> selectApplicationUserByUsername(String username);
}
