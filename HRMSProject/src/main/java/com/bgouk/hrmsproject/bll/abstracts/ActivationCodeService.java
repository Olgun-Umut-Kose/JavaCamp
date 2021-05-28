package com.bgouk.hrmsproject.bll.abstracts;

import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.abstracts.ActivationCode;

public interface ActivationCodeService<T extends ActivationCode> {
    Result add(T activationCode);
    Result update(T activationCode);


}
