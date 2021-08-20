package com.nbu.javaproject.doctors.security.config;

import com.google.common.collect.Sets;

import java.util.Set;

public enum UserRole {
    GUEST(Sets.newHashSet()),
    PATIENT(Sets.newHashSet(UserPermission.PATIENT_READ, UserPermission.PATIENT_WRITE)),
    DOCTOR(Sets.newHashSet(UserPermission.DOCTOR_READ, UserPermission.DOCTOR_WRITE)),
    SUPERADMIN(Sets.newHashSet());

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}
