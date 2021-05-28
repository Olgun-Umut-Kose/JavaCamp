package com.bgouk.hrmsproject.core.adapters;

import com.bgouk.hrmsproject.core.utils.result.Result;

import java.time.LocalDate;

public interface UserRealCheckService {
    Result check(Long nationalIdentity, String firstName, String lastName, LocalDate birthDate);
}
