package com.nbu.javaproject.doctors.doctor;

import com.nbu.javaproject.doctors.appointment.Appointment;
import com.nbu.javaproject.doctors.speciality.Speciality;

import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

@Table(name="doctors")
@Entity(name = "doctor")
public class Doctor {
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
    private Long uin;

    @Column(
            nullable = false
    )
    private String password = "test123";

    @Column(
            nullable = false
    )
    private Boolean isGP; // Is general practitioner

    @ManyToOne
    @JoinColumn(name="speciality_id", nullable = false)
    private Speciality speciality;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments;

    public Doctor() {

    }

    public Doctor(String firstName, String lastName, Long uin, Boolean isGP, Speciality speciality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uin = uin;
        this.isGP = isGP;
        this.speciality = speciality;
    }

    public Doctor(Long id, String firstName, String lastName, Long uin, Boolean isGP, Speciality speciality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uin = uin;
        this.isGP = isGP;
        this.speciality = speciality;
    }

    private String getMd5(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] passwordMd5 = md.digest();
        StringBuffer sb = new StringBuffer();
        for(byte b : passwordMd5) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        return sb.toString();
    }

    @PrePersist
    private void prePersist() throws NoSuchAlgorithmException {
        // Hash password before save
        this.setPassword(this.getMd5(this.getPassword()));
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

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public String getPassword() {
        return password;
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
