package com.bgouk.hrmsproject.bll.concretes.auth;

import com.bgouk.hrmsproject.bll.abstracts.ActivationCodeService;
import com.bgouk.hrmsproject.bll.abstracts.auth.EmailVerificationService;
import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.core.utils.result.ErrorResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
import com.bgouk.hrmsproject.entities.concretes.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmailVerificationManager implements EmailVerificationService {


    private final ActivationCodeService activationCodeService;

    @Autowired
    public EmailVerificationManager(ActivationCodeService activationCodeService) {
        this.activationCodeService = activationCodeService;
    }

    @Override
    public Result verify(int userId, String code) {
        Optional<ActivationCode> activationCode = activationCodeService.getByUserId(userId).getData();
        Result result = verifyControl(activationCode,code);
        if (!result.isSuccess()) return result;
        activationCode.get().setIsConfirmed(true);
        activationCode.get().setConfirmedDate(LocalDateTime.now());
        Result updateResult = activationCodeService.update(activationCode.get());
        if (!updateResult.isSuccess()) return updateResult;
        return new SuccessResult(Messages.codeConfirmed);

    }
    private Result verifyControl(Optional<ActivationCode> activationCode, String code){
        if (activationCode.isEmpty()) return new ErrorResult(Messages.activationCodeNotFound);
        if (activationCode.get().getIsConfirmed()) return new ErrorResult(Messages.alreadyConfirmed);
        if (activationCode.get().getExpirationDate().isBefore(LocalDateTime.now())) return new ErrorResult(Messages.codeExpired);
        if (!activationCode.get().getActivationCode().equals(code)) return new ErrorResult(Messages.codeNotEqual);

        return new SuccessResult();

    }
}
