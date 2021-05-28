package com.bgouk.hrmsproject.entities.concretes;

import com.bgouk.hrmsproject.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "job_seekers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue(value = "jobSeeker")
public class JobSeeker extends User {

    @Column(name = "national_identity")
    private String nationalIdentity;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    public JobSeeker(String email, String password, String nationalIdentity, LocalDate birthDate, String firstName, String lastName) {
        super(email, password);
        this.nationalIdentity = nationalIdentity;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
