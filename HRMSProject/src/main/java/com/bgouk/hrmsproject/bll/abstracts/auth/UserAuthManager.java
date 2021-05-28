package com.bgouk.hrmsproject.bll.abstracts.auth;

import com.bgouk.hrmsproject.bll.abstracts.UserService;
import com.bgouk.hrmsproject.bll.concretes.UserManager;
import com.bgouk.hrmsproject.bll.validationRules.AuthValidatorService;
import com.bgouk.hrmsproject.core.utils.business.BusinessEngine;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.verification.CodeGenerator;
import com.bgouk.hrmsproject.entities.abstracts.User;
import com.bgouk.hrmsproject.entities.dtos.AuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class UserAuthManager<T extends User> implements UserAuthService<T> {

    private final UserService<T> userService;
    private final AuthValidatorService authValidatorService;




    @Autowired
    public UserAuthManager(UserManager<T> userManager, AuthValidatorService authValidatorService) {
        this.userService = userManager;
        this.authValidatorService = authValidatorService;


    }

    @Override
    public Result register(AuthDto authDto) {
        Result result = BusinessEngine.run(authValidatorService.AuthNullCheck(authDto),authValidatorService.confirmPassword(authDto));
        if (!result.isSuccess()){
            return result;
        }
        T user = newUserInstance(authDto);
        Result userResult = userService.add(user);
        if (!userResult.isSuccess()){
            return userResult;
        }
        String code = CodeGenerator.generateUUIDCode();
        return emailActivation(user.getId(),code); // eğer sistem personeli email doğrulamayacak ise bu üst sınıfa taşınır
    }

    public abstract T newUserInstance(AuthDto authDto);

    public abstract Result emailActivation(int userId,String code);
}
