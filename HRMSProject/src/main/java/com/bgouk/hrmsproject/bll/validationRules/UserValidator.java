package com.bgouk.hrmsproject.bll.validationRules;

import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.core.utils.result.ErrorResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
import com.bgouk.hrmsproject.entities.abstracts.User;
import org.springframework.stereotype.Component;

@Component
public abstract class UserValidator{

    public Result userNullCheck(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        if((email==null||email.isBlank())||(password==null||password.isBlank())){
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }
}
