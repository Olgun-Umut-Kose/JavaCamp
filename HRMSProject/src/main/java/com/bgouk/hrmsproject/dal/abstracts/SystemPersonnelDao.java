package com.bgouk.hrmsproject.dal.abstracts;

import com.bgouk.hrmsproject.entities.concretes.SystemPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel,Integer> {
}
