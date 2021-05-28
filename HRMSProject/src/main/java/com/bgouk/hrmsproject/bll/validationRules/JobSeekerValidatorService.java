package com.bgouk.hrmsproject.bll.validationRules;

import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.concretes.JobSeeker;

public interface JobSeekerValidatorService {
    Result jobSeekerNullCheck(JobSeeker jobSeeker);
    Result nationalIdValid(String nationalIdentity);
}
