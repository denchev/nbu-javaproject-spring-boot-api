package com.nbu.javaproject.doctors.speciality;

import com.nbu.javaproject.doctors.user.doctor.Doctor;

import javax.persistence.*;
import java.util.List;

@Table(name="specialities")
@Entity(name = "speciality")
public class Speciality {

    @Id
    @SequenceGenerator(
            name = "speciality_sequence",
            sequenceName = "speciality_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "speciality_sequence"
    )
    private Long id;
    private String name;

    @OneToMany(mappedBy = "speciality")
    private List<Doctor> doctors;

    public Speciality() {

    }

    public Speciality(String name) {
        this.name = name;
    }

    public Speciality(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
