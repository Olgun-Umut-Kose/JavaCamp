package com.bgouk.hrmsproject.bll.abstracts.auth;

import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.abstracts.User;
import com.bgouk.hrmsproject.entities.dtos.AuthDto;

public interface UserAuthService<T extends User> {
    Result register(AuthDto authDto);
}
