package com.bgouk.hrmsproject.entities.concretes;

import com.bgouk.hrmsproject.entities.abstracts.ActivationCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "activation_code_to_employers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class EmployerActivationCode extends ActivationCode {

    @Column(name = "employer_id")
    private int employerId;

    public EmployerActivationCode(String activationCode, int employerId) {
        super(activationCode);
        this.employerId = employerId;
    }
}