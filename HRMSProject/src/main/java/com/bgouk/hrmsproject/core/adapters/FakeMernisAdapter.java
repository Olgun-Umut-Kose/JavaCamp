package com.bgouk.hrmsproject.core.adapters;

import com.bgouk.hrmsproject.core.utils.result.ErrorResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
import com.bgouk.hrmsproject.services.FakeMernisService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FakeMernisAdapter implements UserRealCheckService{
    @Override
    public Result check(Long nationalIdentity, String firstName, String lastName, LocalDate birthDate) {
        FakeMernisService fakeMernisService = new FakeMernisService();
        if (!fakeMernisService.check(nationalIdentity,firstName,lastName,birthDate)){
            return new ErrorResult("Kullanıcı Gerçek değil");
        }
        return new SuccessResult();
    }
}
