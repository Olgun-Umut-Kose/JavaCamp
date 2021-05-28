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
@Table(name = "activation_code_to_job_seekers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class JobSeekerActivationCode extends ActivationCode {

    @Column(name = "job_seeker_id")
    private int jobSeekerId;

    public JobSeekerActivationCode(String activationCode, int jobSeekerId) {
        super(activationCode);
        this.jobSeekerId = jobSeekerId;
    }
}
