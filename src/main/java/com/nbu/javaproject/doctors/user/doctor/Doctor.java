package com.nbu.javaproject.doctors.user.doctor;

import com.nbu.javaproject.doctors.appointment.Appointment;
import com.nbu.javaproject.doctors.speciality.Speciality;
import com.nbu.javaproject.doctors.security.config.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Table(name="doctors")
@Entity(name = "doctor")
public class Doctor implements UserDetails {
    @Id
    @SequenceGenerator(
            name = "doctor_sequence",
            sequenceName = "doctor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_sequence"
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
            unique = true,
            nullable = false
    )
    private String uin;

    @Column(
            nullable = false
    )
    private String password;

    @Column(
            nullable = false
    )
    private Boolean isGP; // Is general practitioner

    @ManyToOne
    @JoinColumn(name="speciality_id", nullable = false)
    private Speciality speciality;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments;

    private UserRole userRole = UserRole.DOCTOR;

    public Doctor() {

    }

    public Doctor(String firstName, String lastName, String uin, Boolean isGP, Speciality speciality, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uin = uin;
        this.isGP = isGP;
        this.speciality = speciality;
        this.password = password;
    }

    public Doctor(Long id, String firstName, String lastName, String uin, Boolean isGP, Speciality speciality) {
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

    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }

    public Boolean getGP() {
        return isGP;
    }

    public void setGP(Boolean GP) {
        isGP = GP;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + UserRole.DOCTOR.name());
        return Collections.singletonList(authority);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return uin;
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

    public void setPassword(String password) {
        this.password = password;
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
