package com.nbu.javaproject.doctors.security.config;

public enum UserPermission {
    PATIENT_READ("patient:read"),
    PATIENT_WRITE("patient_write"),
    DOCTOR_READ("doctor:read"),
    DOCTOR_WRITE("doctor:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }
}
