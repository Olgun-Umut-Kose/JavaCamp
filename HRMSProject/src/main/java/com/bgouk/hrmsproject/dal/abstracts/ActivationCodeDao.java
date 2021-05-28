package com.bgouk.hrmsproject.dal.abstracts;

import com.bgouk.hrmsproject.entities.abstracts.ActivationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivationCodeDao<T extends ActivationCode> extends JpaRepository<T,Integer> {
}
