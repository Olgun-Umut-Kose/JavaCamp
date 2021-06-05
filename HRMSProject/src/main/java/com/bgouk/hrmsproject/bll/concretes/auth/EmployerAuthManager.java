package com.bgouk.hrmsproject.bll.concretes.auth;

import com.bgouk.hrmsproject.bll.abstracts.ActivationCodeService;
import com.bgouk.hrmsproject.bll.concretes.UserManager;
import com.bgouk.hrmsproject.bll.abstracts.auth.EmployerAuthService;
import com.bgouk.hrmsproject.bll.abstracts.auth.UserAuthManager;
import com.bgouk.hrmsproject.bll.validationRules.AuthValidatorService;
import com.bgouk.hrmsproject.core.utils.email.EmailSenderService;
import com.bgouk.hrmsproject.entities.concretes.Employer;
import com.bgouk.hrmsproject.entities.dtos.RegisterDto;
import com.bgouk.hrmsproject.entities.dtos.RegisterForEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerAuthManager extends UserAuthManager<Employer> implements EmployerAuthService{


    @Autowired
    public EmployerAuthManager(UserManager<Employer> userManager, AuthValidatorService authValidatorService, ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
        super(userManager, authValidatorService, activationCodeService, emailSenderService);
    }

    @Override
    public Employer newUserInstance(RegisterDto registerDto) {
        RegisterForEmployerDto dto = (RegisterForEmployerDto) registerDto;
        return new Employer(dto.getEmail(),dto.getPassword(),dto.getCompanyName(),dto.getWebAddress(),dto.getPhoneNumber());
    }





}
