package com.bgouk.hrmsproject.bll.abstracts.auth;

import com.bgouk.hrmsproject.bll.abstracts.ActivationCodeService;
import com.bgouk.hrmsproject.bll.abstracts.UserService;
import com.bgouk.hrmsproject.bll.concretes.UserManager;
import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.bll.validationRules.AuthValidatorService;
import com.bgouk.hrmsproject.core.utils.business.BusinessEngine;
import com.bgouk.hrmsproject.core.utils.email.EmailSenderService;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
import com.bgouk.hrmsproject.core.utils.verification.CodeGenerator;
import com.bgouk.hrmsproject.entities.abstracts.User;
import com.bgouk.hrmsproject.entities.concretes.ActivationCode;
import com.bgouk.hrmsproject.entities.dtos.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class UserAuthManager<T extends User> implements UserAuthService<T> {

    private final UserService<T> userService;
    private final AuthValidatorService authValidatorService;
    private final ActivationCodeService activationCodeService;
    private final EmailSenderService emailSenderService;


    @Autowired
    public UserAuthManager(UserManager<T> userManager, AuthValidatorService authValidatorService, ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
        this.userService = userManager;
        this.authValidatorService = authValidatorService;
        this.activationCodeService = activationCodeService;
        this.emailSenderService = emailSenderService;
    }

    @Override
    public Result register(RegisterDto registerDto) {
        Result result = BusinessEngine.run(authValidatorService.AuthNullCheck(registerDto),authValidatorService.confirmPassword(registerDto));
        if (!result.isSuccess()){
            return result;
        }
        T user = newUserInstance(registerDto);
        Result userResult = userService.add(user);
        if (!userResult.isSuccess()){
            return userResult;
        }
        Result activationResult = emailActivation(user); // eğer sistem personeli email doğrulamayacak ise bu üst sınıfa taşınır
        if (!activationResult.isSuccess()){
            return activationResult;
        }
        return new SuccessResult(Messages.userAdded);
    }

    public abstract T newUserInstance(RegisterDto registerDto);

    public Result emailActivation(T user) {
        String code = CodeGenerator.generateUUIDCode();
        Optional<ActivationCode> optionalActivationCode = activationCodeService.getByUserId(user.getId()).getData();
        if (optionalActivationCode.isPresent()){
            //delete
        }
        ActivationCode activationCode = new ActivationCode(code,user);
        Result activationResult = activationCodeService.add(activationCode);
        if(!activationResult.isSuccess()){
            return activationResult;
        }
        emailSenderService.send("aktivasyon kodunu: " + code);
        return new SuccessResult();
    }
}
