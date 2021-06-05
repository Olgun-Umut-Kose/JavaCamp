package com.bgouk.hrmsproject.bll.concretes;

import com.bgouk.hrmsproject.bll.abstracts.JobPositionService;
import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.core.utils.business.BusinessEngine;
import com.bgouk.hrmsproject.core.utils.result.*;
import com.bgouk.hrmsproject.dal.abstracts.JobPositionDao;
import com.bgouk.hrmsproject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
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
        Result result = BusinessEngine.run(titleEquals(jobPosition.getTitle()));
        if (!result.isSuccess()){
            return result;
        }
        jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.jobPositionAdded);
    }

    private Result titleEquals(String title){
        if (jobPositionDao.findByTitleIgnoreCase(title).isPresent()){
            return new ErrorResult(Messages.titleEquals);
        }
        return new SuccessResult();
    }
}
