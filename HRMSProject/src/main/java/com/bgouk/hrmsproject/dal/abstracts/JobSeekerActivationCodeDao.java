package com.bgouk.hrmsproject.dal.abstracts;

import com.bgouk.hrmsproject.entities.concretes.JobSeekerActivationCode;

import java.util.Optional;

public interface JobSeekerActivationCodeDao extends ActivationCodeDao<JobSeekerActivationCode> {

    Optional<JobSeekerActivationCode> findByJobSeekerId(int jobSeekerId);
}
