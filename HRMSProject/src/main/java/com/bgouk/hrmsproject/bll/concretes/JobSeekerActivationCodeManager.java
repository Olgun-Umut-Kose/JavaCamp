package com.bgouk.hrmsproject.bll.concretes;

import com.bgouk.hrmsproject.bll.abstracts.ActivationCodeManager;
import com.bgouk.hrmsproject.bll.abstracts.JobSeekerActivationCodeService;
import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.core.utils.result.SuccessDataResult;
import com.bgouk.hrmsproject.dal.abstracts.ActivationCodeDao;
import com.bgouk.hrmsproject.dal.abstracts.JobSeekerActivationCodeDao;
import com.bgouk.hrmsproject.entities.concretes.JobSeekerActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobSeekerActivationCodeManager extends ActivationCodeManager<JobSeekerActivationCode> implements JobSeekerActivationCodeService {

    private final JobSeekerActivationCodeDao jobSeekerActivationCodeDao;

    @Autowired
    public JobSeekerActivationCodeManager(ActivationCodeDao<JobSeekerActivationCode> activationCodeDao) {
        super(activationCodeDao);
        this.jobSeekerActivationCodeDao = (JobSeekerActivationCodeDao) activationCodeDao;
    }

    @Override
    public DataResult<Optional<JobSeekerActivationCode>> getByJobSeekerId(int jobSeekerId) {
        return new SuccessDataResult<>(jobSeekerActivationCodeDao.findByJobSeekerId(jobSeekerId));
    }
}
