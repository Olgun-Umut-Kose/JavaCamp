package com.bgouk.hrmsproject.bll.abstracts;

import com.bgouk.hrmsproject.bll.abstracts.ActivationCodeService;
import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
import com.bgouk.hrmsproject.dal.abstracts.ActivationCodeDao;
import com.bgouk.hrmsproject.entities.abstracts.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public abstract class ActivationCodeManager<T extends ActivationCode> implements ActivationCodeService<T> {

    private final ActivationCodeDao<T> activationCodeDao;

    @Autowired
    public ActivationCodeManager(ActivationCodeDao<T> activationCodeDao) {
        this.activationCodeDao = activationCodeDao;
    }

    @Override
    public Result add(T activationCode) {
        activationCode.setExpirationDate(LocalDateTime.now().plusMinutes(15));
        activationCodeDao.save(activationCode);
        return new SuccessResult(Messages.activationCodeAdded);
    }

    @Override
    public Result update(T activationCode) {
        activationCodeDao.save(activationCode);
        return new SuccessResult(Messages.activationCodeUpdated);
    }
}
