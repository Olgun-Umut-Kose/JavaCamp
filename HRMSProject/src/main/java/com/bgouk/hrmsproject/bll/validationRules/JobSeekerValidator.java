package com.bgouk.hrmsproject.bll.validationRules;

import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.core.utils.result.ErrorResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
import com.bgouk.hrmsproject.entities.concretes.JobSeeker;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class JobSeekerValidator extends UserValidator implements JobSeekerValidatorService{

    @Override
    public Result jobSeekerNullCheck(JobSeeker jobSeeker) {
        String firstName = jobSeeker.getFirstName();
        String lastName = jobSeeker.getLastName();
        String nationalIdentity = jobSeeker.getNationalIdentity();
        LocalDate birth = jobSeeker.getBirthDate();

        if(!super.userNullCheck(jobSeeker).isSuccess()||(firstName == null
                ||firstName.isBlank() || (lastName == null
                || lastName.isBlank()))||(nationalIdentity==null || nationalIdentity.isBlank())||birth == null)
        {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }

    @Override
    public Result nationalIdValid(String nationalIdentity) {
        if(nationalIdentity.length()==11){
            return new SuccessResult();

        }
        return new ErrorResult(Messages.nationalIdNotValid);
    }

}
