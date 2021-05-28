package com.bgouk.hrmsproject.bll.abstracts;

import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.entities.concretes.JobSeekerActivationCode;

import java.util.Optional;

public interface JobSeekerActivationCodeService extends ActivationCodeService<JobSeekerActivationCode> {
    DataResult<Optional<JobSeekerActivationCode>> getByJobSeekerId(int jobSeekerId);
}
