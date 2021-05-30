package com.bgouk.hrmsproject.bll.concretes.auth;

import com.bgouk.hrmsproject.bll.abstracts.ActivationCodeService;
import com.bgouk.hrmsproject.bll.concretes.UserManager;
import com.bgouk.hrmsproject.bll.abstracts.auth.EmailVerificationService;
import com.bgouk.hrmsproject.bll.abstracts.auth.JobSeekerAuthService;
import com.bgouk.hrmsproject.bll.abstracts.auth.UserAuthManager;
import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.bll.validationRules.AuthValidatorService;
import com.bgouk.hrmsproject.core.utils.email.EmailSenderService;
import com.bgouk.hrmsproject.core.utils.result.ErrorResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
import com.bgouk.hrmsproject.entities.concretes.JobSeeker;
import com.bgouk.hrmsproject.entities.dtos.AuthDto;
import com.bgouk.hrmsproject.entities.dtos.RegisterForJobSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class JobSeekerAuthManager extends UserAuthManager<JobSeeker> implements JobSeekerAuthService {


    @Autowired
    public JobSeekerAuthManager(UserManager<JobSeeker> userManager, AuthValidatorService authValidatorService, ActivationCodeService activationCodeService, EmailSenderService emailSenderService) {
        super(userManager, authValidatorService, activationCodeService, emailSenderService);
    }

    @Override
    public JobSeeker newUserInstance(AuthDto authDto) {
        RegisterForJobSeekerDto dto = (RegisterForJobSeekerDto) authDto;
        return new JobSeeker(dto.getEmail(),dto.getPassword(),dto.getNationalIdentity(),dto.getBirthDate(),dto.getFirstName(),dto.getLastName());
    }



}
