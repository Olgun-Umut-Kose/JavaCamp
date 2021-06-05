package com.bgouk.hrmsproject.bll.validationRules;

import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.dtos.RegisterDto;

public interface AuthValidatorService {
    Result AuthNullCheck(RegisterDto registerDto);
    Result confirmPassword(RegisterDto registerDto);
}
