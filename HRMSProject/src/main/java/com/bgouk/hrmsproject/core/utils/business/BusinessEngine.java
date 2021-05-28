package com.bgouk.hrmsproject.core.utils.business;

import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
import org.hibernate.annotations.common.reflection.ReflectionUtil;

public class BusinessEngine {
    public static Result run(Result... logics) {
        for (Result logic : logics) {
            if (!logic.isSuccess()){
                return logic;
            }
        }
        return new SuccessResult();
    }
}
