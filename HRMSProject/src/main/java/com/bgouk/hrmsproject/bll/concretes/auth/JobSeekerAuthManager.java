package com.bgouk.hrmsproject.bll.concretes.auth;

import com.bgouk.hrmsproject.bll.abstracts.JobSeekerActivationCodeService;
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
import com.bgouk.hrmsproject.entities.concretes.JobSeekerActivationCode;
import com.bgouk.hrmsproject.entities.dtos.AuthDto;
import com.bgouk.hrmsproject.entities.dtos.RegisterForJobSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class JobSeekerAuthManager extends UserAuthManager<JobSeeker> implements JobSeekerAuthService, EmailVerificationService {
    
    private final JobSeekerActivationCodeService jobSeekerActivationCodeService;
    private final EmailSenderService emailSenderService;
    
    @Autowired
    public JobSeekerAuthManager(UserManager<JobSeeker> userManager, AuthValidatorService authValidatorService, EmailSenderService emailSenderService, JobSeekerActivationCodeService activationCodeService) {
        super(userManager, authValidatorService);
        this.jobSeekerActivationCodeService = activationCodeService;
        this.emailSenderService = emailSenderService;
    }

    @Override
    public JobSeeker newUserInstance(AuthDto authDto) {
        RegisterForJobSeekerDto dto = (RegisterForJobSeekerDto) authDto;
        return new JobSeeker(dto.getEmail(),dto.getPassword(),dto.getNationalIdentity(),dto.getBirthDate(),dto.getFirstName(),dto.getLastName());
    }


    private JobSeekerActivationCode newActivationCodeInstance(int userId, String code) {
        return new JobSeekerActivationCode(code,userId);
    }

    @Override
    public Result emailActivation(int userId, String code) {
        Optional<JobSeekerActivationCode> optionalActivationCode = jobSeekerActivationCodeService.getByJobSeekerId(userId).getData();
        if (optionalActivationCode.isPresent()){
            //delete
        }
        JobSeekerActivationCode activationCode = newActivationCodeInstance(userId,code);
        Result activationResult = jobSeekerActivationCodeService.add(activationCode);
        if(!activationResult.isSuccess()){
            return activationResult;
        }
        emailSenderService.send("aktivasyon kodunu: " + code);
        return new SuccessResult(Messages.userAdded);
    }


    @Override
    public Result verify(int userId, String code) {
        Optional<JobSeekerActivationCode> activationCode = jobSeekerActivationCodeService.getByJobSeekerId(userId).getData();
        Result result = verifyControl(activationCode,code);
        if (!result.isSuccess()){
            return result;
        }
        activationCode.get().setIsConfirmed(true);
        activationCode.get().setConfirmedDate(LocalDate.now());
        Result updateResult = jobSeekerActivationCodeService.update(activationCode.get());
        if (!updateResult.isSuccess()) return updateResult;
        return new SuccessResult(Messages.codeConfirmed);

    }
    private Result verifyControl(Optional<JobSeekerActivationCode> activationCode, String code){
        if (activationCode.isEmpty()){
            return new ErrorResult(Messages.activationCodeNotFound);
        }
        if (activationCode.get().getIsConfirmed()){
            return new ErrorResult(Messages.alreadyConfirmed);
        }
        if (activationCode.get().getExpirationDate().isBefore(LocalDateTime.now())){
            return new ErrorResult(Messages.codeExpired);
        }
        if (!activationCode.get().getActivationCode().equals(code)){
            return new ErrorResult(Messages.codeNotEqual);
        }

        return new SuccessResult();

    }
}
