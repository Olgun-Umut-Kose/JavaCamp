package com.bgouk.hrmsproject.dal.abstracts;

import com.bgouk.hrmsproject.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {

    Optional<JobPosition> findByTitleIgnoreCase(String title);

}
