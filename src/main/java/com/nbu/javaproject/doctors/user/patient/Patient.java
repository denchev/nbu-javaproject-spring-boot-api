package com.nbu.javaproject.doctors.user.patient;

import com.nbu.javaproject.doctors.appointment.Appointment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Table(name = "patients")
@Entity(name = "patient")
public class Patient implements UserDetails {
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

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments;

    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName, Boolean isInsured, String egn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isInsured = isInsured;
        this.egn = egn;
    }

    public Patient(String firstName, String lastName, Boolean isInsured, String egn) {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
