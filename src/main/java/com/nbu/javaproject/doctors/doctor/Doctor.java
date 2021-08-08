package com.nbu.javaproject.doctors.doctor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "doctor")
public class Doctor {
    @Id
    private Long id;

    @Column(
            nullable = false
    )
    private String firstName;

    @Column(
            nullable = false
    )
    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private Long uin;

    @Column(
            nullable = false
    )
    private Boolean isGP; // Is general practitioner
    private String speciality; // @TODO Connection to speciality entity

    public Doctor() {

    }

    public Doctor(Long id, String firstName, String lastName, Long uin, Boolean isGP, String speciality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uin = uin;
        this.isGP = isGP;
        this.speciality = speciality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getUin() {
        return uin;
    }

    public void setUin(Long uin) {
        this.uin = uin;
    }

    public Boolean getGP() {
        return isGP;
    }

    public void setGP(Boolean GP) {
        isGP = GP;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", uin=" + uin +
                ", isGP=" + isGP +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
