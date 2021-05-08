package com.bgouk.Abstract;

import java.time.LocalDate;

public abstract class Person extends Entity{

    private String nationalityId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Person() {
    }

    public Person(int id, String nationalityId, String firstName, String lastName, LocalDate dateOfBirth) {
        super(id);
        this.setNationalityId(nationalityId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDateOfBirth(dateOfBirth);
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
