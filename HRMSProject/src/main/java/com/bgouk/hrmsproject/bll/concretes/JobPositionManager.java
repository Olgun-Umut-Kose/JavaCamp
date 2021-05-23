package com.bgouk.hrmsproject.bll.concretes;

import com.bgouk.hrmsproject.bll.abstracts.JobPositionService;
import com.bgouk.hrmsproject.dal.abstracts.JobPositionDao;
import com.bgouk.hrmsproject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private final JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobPosition> getAll() {
        return jobPositionDao.findAll();
    }

    @Override
    public void add(JobPosition jobPosition) {
        jobPositionDao.save(jobPosition);
    }
}
