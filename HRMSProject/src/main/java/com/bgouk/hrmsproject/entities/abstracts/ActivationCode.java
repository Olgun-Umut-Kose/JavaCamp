package com.bgouk.hrmsproject.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "activation_codes")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ActivationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "is_confirmed")
    private Boolean isConfirmed = false;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "confirmed_date")
    private LocalDate confirmedDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    public ActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
}
