package com.bgouk.hrmsproject.bll.concretes;

import com.bgouk.hrmsproject.bll.abstracts.JobPositionService;
import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessDataResult;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
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
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(jobPositionDao.findAll(), Messages.jobPositionListed);
    }

    @Override
    public Result add(JobPosition jobPosition) {
        jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.jobPositionAdded);
    }
}
