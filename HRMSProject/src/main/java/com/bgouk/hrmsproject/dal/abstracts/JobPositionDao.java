package com.bgouk.hrmsproject.dal.abstracts;

import com.bgouk.hrmsproject.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
}
