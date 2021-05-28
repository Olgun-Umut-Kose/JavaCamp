package com.bgouk.hrmsproject.bll.concretes.auth;

import com.bgouk.hrmsproject.bll.abstracts.EmployerActivationCodeService;
import com.bgouk.hrmsproject.bll.concretes.UserManager;
import com.bgouk.hrmsproject.bll.abstracts.auth.EmailVerificationService;
import com.bgouk.hrmsproject.bll.abstracts.auth.EmployerAuthService;
import com.bgouk.hrmsproject.bll.abstracts.auth.UserAuthManager;
import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.bll.validationRules.AuthValidatorService;
import com.bgouk.hrmsproject.core.utils.email.EmailSenderService;
import com.bgouk.hrmsproject.core.utils.result.ErrorResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
import com.bgouk.hrmsproject.entities.concretes.Employer;
import com.bgouk.hrmsproject.entities.concretes.EmployerActivationCode;
import com.bgouk.hrmsproject.entities.dtos.AuthDto;
import com.bgouk.hrmsproject.entities.dtos.RegisterForEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmployerAuthManager extends UserAuthManager<Employer> implements EmployerAuthService, EmailVerificationService {
    private final EmployerActivationCodeService employerActivationCodeService;
    private final EmailSenderService emailSenderService;

    @Autowired
    public EmployerAuthManager(UserManager<Employer> userManager, AuthValidatorService authValidatorService, EmailSenderService emailSenderService, EmployerActivationCodeService activationCodeService) {
        super(userManager, authValidatorService);
        this.employerActivationCodeService = activationCodeService;
        this.emailSenderService = emailSenderService;
    }


    @Override
    public Employer newUserInstance(AuthDto authDto) {
        RegisterForEmployerDto dto = (RegisterForEmployerDto) authDto;
        return new Employer(dto.getEmail(),dto.getPassword(),dto.getCompanyName(),dto.getWebAddress(),dto.getPhoneNumber());
    }

    private EmployerActivationCode newActivationCodeInstance(int userId, String code) {
        return new EmployerActivationCode(code,userId);
    }

    @Override
    public Result emailActivation(int userId, String code) {
        Optional<EmployerActivationCode> optionalActivationCode = employerActivationCodeService.getByEmployerId(userId).getData();
        if (optionalActivationCode.isPresent()){
            //delete
        }
        EmployerActivationCode activationCode = newActivationCodeInstance(userId,code);
        Result activationResult = employerActivationCodeService.add(activationCode);
        if(!activationResult.isSuccess()){
            return activationResult;
        }
        emailSenderService.send("aktivasyon kodunu: " + code);
        return new SuccessResult(Messages.userAdded);
    }

    @Override
    public Result verify(int userId, String code) {
        Optional<EmployerActivationCode> activationCode = employerActivationCodeService.getByEmployerId(userId).getData();
        Result result = verifyControl(activationCode,code);
        if (!result.isSuccess()){
            return result;
        }
        activationCode.get().setIsConfirmed(true);
        activationCode.get().setConfirmedDate(LocalDate.now());
        Result updateResult = employerActivationCodeService.update(activationCode.get());
        if (!updateResult.isSuccess()) return updateResult;
        return new SuccessResult(Messages.codeConfirmed);

    }
    private Result verifyControl(Optional<EmployerActivationCode> activationCode, String code){
        if (activationCode.isEmpty()){
            return new ErrorResult(Messages.activationCodeNotFound);
        }
        if (activationCode.get().getIsConfirmed()){
            return new ErrorResult(Messages.alreadyConfirmed);
        }
        if (activationCode.get().getExpirationDate().isBefore(LocalDateTime.now())){
            return new ErrorResult(Messages.codeExpired);
        }
        if (!activationCode.get().getActivationCode().equals(code)){
            return new ErrorResult(Messages.codeNotEqual);
        }

        return new SuccessResult();

    }
}
