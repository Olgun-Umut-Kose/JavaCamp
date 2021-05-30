package com.bgouk.hrmsproject.bll.concretes;

import com.bgouk.hrmsproject.bll.abstracts.ActivationCodeService;
import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessDataResult;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
import com.bgouk.hrmsproject.dal.abstracts.ActivationCodeDao;
import com.bgouk.hrmsproject.entities.concretes.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ActivationCodeManager implements ActivationCodeService {

    private final ActivationCodeDao activationCodeDao;

    @Autowired
    public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
        this.activationCodeDao = activationCodeDao;
    }

    @Override
    public Result add(ActivationCode activationCode) {
        activationCode.setExpirationDate(LocalDateTime.now().plusMinutes(15));
        activationCodeDao.save(activationCode);
        return new SuccessResult(Messages.activationCodeAdded);
    }

    @Override
    public Result update(ActivationCode activationCode) {
        activationCodeDao.save(activationCode);
        return new SuccessResult(Messages.activationCodeUpdated);
    }

    @Override
    public DataResult<Optional<ActivationCode>> getByUserId(int userId) {
        return new SuccessDataResult<Optional<ActivationCode>>(activationCodeDao.findByUserId(userId));
    }
}
