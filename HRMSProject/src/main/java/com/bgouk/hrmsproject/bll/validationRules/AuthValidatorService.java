package com.bgouk.hrmsproject.bll.validationRules;

import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.dtos.AuthDto;

public interface AuthValidatorService {
    Result AuthNullCheck(AuthDto authDto);
    Result confirmPassword(AuthDto authDto);
}
