package com.bgouk.hrmsproject.dal.abstracts;

import com.bgouk.hrmsproject.entities.concretes.ActivationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivationCodeDao extends JpaRepository<ActivationCode,Integer> {

    Optional<ActivationCode> findByUserId(int userId);
}
