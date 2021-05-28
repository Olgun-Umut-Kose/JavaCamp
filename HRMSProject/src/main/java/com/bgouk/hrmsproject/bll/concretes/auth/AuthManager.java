package com.bgouk.hrmsproject.bll.concretes.auth;

import com.bgouk.hrmsproject.bll.abstracts.JobSeekerService;
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
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthManager implements AuthService {

    private final UserService<?> userService;
    private final JobSeekerAuthService jobSeekerAuthService;
    private final EmployerAuthService employerAuthService;

    @Autowired
    public AuthManager( UserService<?> userService, JobSeekerAuthService jobSeekerAuthService, EmployerAuthService employerAuthService) {
        this.userService = userService;
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
    public Result verify(int userId, String code) throws NoSuchFieldException, IllegalAccessException {
        Optional<User> user = (Optional<User>) userService.getById(userId).getData();
        if (user.isEmpty()){
            return new ErrorResult(Messages.userNotFound);
        }
        EmailVerificationService authManager = (EmailVerificationService) this.getClass().getDeclaredField(user.get().getType()+"AuthService").get(this);
        return authManager.verify(userId,code);

    }
}
