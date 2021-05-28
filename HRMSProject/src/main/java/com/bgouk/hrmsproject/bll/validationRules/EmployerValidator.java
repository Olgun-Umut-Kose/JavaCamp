package com.bgouk.hrmsproject.bll.validationRules;

import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.core.utils.result.ErrorResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
import com.bgouk.hrmsproject.entities.concretes.Employer;
import org.springframework.stereotype.Component;

@Component
public class EmployerValidator extends UserValidator implements EmployerValidatorService {
    @Override
    public Result employerNullCheck(Employer employer) {
     String companyName = employer.getCompanyName();
     String webAddress = employer.getWebAddress();
     String phoneNumber = employer.getPhoneNumber();

     if(!super.userNullCheck(employer).isSuccess()||(companyName==null||companyName.isBlank())||(webAddress==null||webAddress.isBlank())||
                (phoneNumber==null||phoneNumber.isBlank())){
            return new ErrorResult(Messages.notNull);
        }
     return new SuccessResult();
     }

    @Override
    public Result isEmailDomainCheck(Employer employer) {
        String email = employer.getEmail();
        String webAdress = employer.getWebAddress();

        String domain = webAdress.split("www.")[1];
        if(domain.equals(email.split("@")[1])){
            return new SuccessResult();
        }
        return new ErrorResult(Messages.domainNotEqual);
    }

}