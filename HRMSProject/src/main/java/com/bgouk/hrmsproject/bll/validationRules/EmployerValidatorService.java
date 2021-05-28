package com.bgouk.hrmsproject.bll.validationRules;

import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.concretes.Employer;

public interface EmployerValidatorService {
    Result employerNullCheck(Employer employer);
    Result isEmailDomainCheck(Employer employer);
}
