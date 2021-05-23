package com.bgouk.hrmsproject.bll.abstracts;

import com.bgouk.hrmsproject.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getAll();
    void add(JobPosition jobPosition);
}
