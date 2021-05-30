package com.bgouk.hrmsproject.bll.abstracts;

import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.concretes.ActivationCode;

import javax.xml.crypto.Data;
import java.util.Optional;

public interface ActivationCodeService {
    Result add(ActivationCode activationCode);
    Result update(ActivationCode activationCode);
    DataResult<Optional<ActivationCode>> getByUserId(int userId);


}
