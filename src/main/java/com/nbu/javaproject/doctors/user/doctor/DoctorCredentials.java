package com.nbu.javaproject.doctors.user.doctor;

public class DoctorCredentials {
    private final String uid;

    private final String password;

    public DoctorCredentials(String uid, String password) {
        this.uid = uid;
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }
}
