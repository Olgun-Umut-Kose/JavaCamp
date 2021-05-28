package com.bgouk.hrmsproject.bll.concretes;

import com.bgouk.hrmsproject.bll.abstracts.EmployerService;
import com.bgouk.hrmsproject.bll.validationRules.EmployerValidatorService;
import com.bgouk.hrmsproject.core.utils.business.BusinessEngine;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.dal.abstracts.UserDao;
import com.bgouk.hrmsproject.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerManager extends UserManager<Employer> implements EmployerService {

    private final EmployerValidatorService employerValidatorService;

    @Autowired
    public EmployerManager(UserDao<Employer> userDao,EmployerValidatorService employerValidatorService) {
        super(userDao);
        this.employerValidatorService = employerValidatorService;
    }

    @Override
    public Result add(Employer user) {
        Result result = BusinessEngine.run(employerValidatorService.employerNullCheck(user),employerValidatorService.isEmailDomainCheck(user));
        if(!result.isSuccess()){
            return result;
        }
        return super.add(user);
    }
}
