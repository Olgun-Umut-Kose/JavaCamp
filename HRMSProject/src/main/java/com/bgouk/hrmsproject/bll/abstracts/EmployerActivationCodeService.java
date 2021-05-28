package com.bgouk.hrmsproject.bll.abstracts;

import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.entities.concretes.EmployerActivationCode;
import com.bgouk.hrmsproject.entities.concretes.JobSeekerActivationCode;

import java.util.Optional;

public interface EmployerActivationCodeService extends ActivationCodeService<EmployerActivationCode> {
    DataResult<Optional<EmployerActivationCode>> getByEmployerId(int employerId);
}
