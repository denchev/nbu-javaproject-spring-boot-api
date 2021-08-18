package com.nbu.javaproject.doctors.user.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
   Doctor findByUin(String uin);
}
