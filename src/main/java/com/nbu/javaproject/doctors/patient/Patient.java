package com.nbu.javaproject.doctors.patient;

import javax.persistence.*;

@Table(name = "patients")
@Entity(name = "patient")
public class Patient {
    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
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
            nullable = false
    )
    private Boolean isInsured;

    @Column(
            nullable = false,
            unique = true
    )
    private String egn;

    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName, Boolean isInsured, String egn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isInsured = isInsured;
        this.egn = egn;
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

    public Boolean getInsured() {
        return isInsured;
    }

    public void setInsured(Boolean insured) {
        isInsured = insured;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isInsured=" + isInsured +
                ", egn='" + egn + '\'' +
                '}';
    }
}
