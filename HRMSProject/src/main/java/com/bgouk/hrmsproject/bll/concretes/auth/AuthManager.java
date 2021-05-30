package com.bgouk.hrmsproject.bll.concretes.auth;

import com.bgouk.hrmsproject.bll.abstracts.UserService;
import com.bgouk.hrmsproject.bll.abstracts.auth.AuthService;
import com.bgouk.hrmsproject.bll.abstracts.auth.EmailVerificationService;
import com.bgouk.hrmsproject.bll.abstracts.auth.EmployerAuthService;
import com.bgouk.hrmsproject.bll.abstracts.auth.JobSeekerAuthService;
import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.core.utils.result.ErrorResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.abstracts.User;
import com.bgouk.hrmsproject.entities.dtos.RegisterForEmployerDto;
import com.bgouk.hrmsproject.entities.dtos.RegisterForJobSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthManager implements AuthService {


    private final JobSeekerAuthService jobSeekerAuthService;
    private final EmployerAuthService employerAuthService;
    private final EmailVerificationService emailVerificationService;

    @Autowired
    public AuthManager(JobSeekerAuthService jobSeekerAuthService, EmployerAuthService employerAuthService, EmailVerificationService emailVerificationService) {
        this.emailVerificationService = emailVerificationService;
        this.jobSeekerAuthService = jobSeekerAuthService;
        this.employerAuthService = employerAuthService;
    }

    @Override
    public Result jobSeekerRegister(RegisterForJobSeekerDto registerForJobSeekerDto) {
        return jobSeekerAuthService.register(registerForJobSeekerDto);
    }

    @Override
    public Result employerRegister(RegisterForEmployerDto registerForEmployerDto) {
        return employerAuthService.register(registerForEmployerDto);
    }

    @Override
    public Result verify(int userId, String code) {
        return emailVerificationService.verify(userId,code);

    }
}
