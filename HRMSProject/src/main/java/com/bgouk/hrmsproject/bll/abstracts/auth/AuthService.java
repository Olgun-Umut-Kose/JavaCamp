package com.bgouk.hrmsproject.bll.abstracts.auth;

import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.dtos.RegisterForEmployerDto;
import com.bgouk.hrmsproject.entities.dtos.RegisterForJobSeekerDto;

public interface AuthService {
    Result jobSeekerRegister(RegisterForJobSeekerDto registerForJobSeekerDto);
    Result employerRegister(RegisterForEmployerDto registerForEmployerDto);
    Result verify(int userId,String code) throws NoSuchFieldException, IllegalAccessException;
}
