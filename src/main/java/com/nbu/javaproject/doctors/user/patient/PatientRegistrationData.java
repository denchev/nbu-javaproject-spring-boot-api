package com.nbu.javaproject.doctors.user.patient;

public class PatientRegistrationData {
    private final String firstName;
    private final String lastName;
    private final String egn;
    private final String password;

    public PatientRegistrationData(String firstName, String lastName, String egn, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.egn = egn;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEgn() {
        return egn;
    }

    @Override
    public String toString() {
        return "PatientRegistrationData{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", egn='" + egn + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }
}
