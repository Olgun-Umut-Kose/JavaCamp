package com.bgouk.hrmsproject.dal.abstracts;

import com.bgouk.hrmsproject.entities.concretes.EmployerActivationCode;

import java.util.Optional;

public interface EmployerActivationCodeDao extends ActivationCodeDao<EmployerActivationCode> {

    Optional<EmployerActivationCode> findByEmployerId(int employerId);
}
