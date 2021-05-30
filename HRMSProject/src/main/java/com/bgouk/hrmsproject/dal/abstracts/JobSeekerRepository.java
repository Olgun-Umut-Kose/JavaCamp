package com.bgouk.hrmsproject.dal.abstracts;

import com.bgouk.hrmsproject.entities.concretes.JobSeeker;

import java.util.Optional;


public interface JobSeekerRepository extends UserDao<JobSeeker> {

    Optional<JobSeeker> findByNationalIdentity(String nationalIdentity);
}
