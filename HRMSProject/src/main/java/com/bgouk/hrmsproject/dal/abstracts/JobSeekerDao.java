package com.bgouk.hrmsproject.dal.abstracts;

import com.bgouk.hrmsproject.entities.abstracts.User;
import com.bgouk.hrmsproject.entities.concretes.JobSeeker;
import org.springframework.stereotype.Component;

import java.util.Optional;


public interface JobSeekerDao extends UserDao<JobSeeker> {

    Optional<JobSeeker> findByNationalIdentity(String nationalIdentity);
}
