package com.bgouk.hrmsproject.bll.abstracts.auth;

import com.bgouk.hrmsproject.core.utils.result.Result;

public interface EmailVerificationService {
    Result verify(int userId, String code);
}
