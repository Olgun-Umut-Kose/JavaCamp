package com.bgouk.hrmsproject.bll.validationRules;

import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.core.utils.result.ErrorResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
import com.bgouk.hrmsproject.entities.dtos.RegisterDto;
import org.springframework.stereotype.Component;

@Component
public class AuthValidator implements AuthValidatorService{
    @Override
    public Result AuthNullCheck(RegisterDto registerDto) {
        String confirmPass = registerDto.getConfirmPassword();
        if(confirmPass == null || confirmPass.isBlank()){
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }

    @Override
    public Result confirmPassword(RegisterDto registerDto) {
        String confirmPass = registerDto.getConfirmPassword();
        String pass = registerDto.getPassword();
        if (!pass.equals(confirmPass)){
            return new ErrorResult(Messages.passwordNotConfirmed);
        }
        return new SuccessResult();
    }
}
