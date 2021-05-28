package com.bgouk.hrmsproject.bll.concretes;

import com.bgouk.hrmsproject.bll.abstracts.ActivationCodeManager;
import com.bgouk.hrmsproject.bll.abstracts.EmployerActivationCodeService;
import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.core.utils.result.SuccessDataResult;
import com.bgouk.hrmsproject.dal.abstracts.ActivationCodeDao;
import com.bgouk.hrmsproject.dal.abstracts.EmployerActivationCodeDao;
import com.bgouk.hrmsproject.entities.concretes.EmployerActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployerActivationCodeManager extends ActivationCodeManager<EmployerActivationCode> implements EmployerActivationCodeService {

    private final EmployerActivationCodeDao employerActivationCodeDao;

    @Autowired
    public EmployerActivationCodeManager(ActivationCodeDao<EmployerActivationCode> activationCodeDao) {
        super(activationCodeDao);
        this.employerActivationCodeDao = (EmployerActivationCodeDao) activationCodeDao;
    }

    @Override
    public DataResult<Optional<EmployerActivationCode>> getByEmployerId(int employerId) {
        return new SuccessDataResult<>(employerActivationCodeDao.findByEmployerId(employerId));
    }

}
