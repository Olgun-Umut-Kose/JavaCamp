package com.bgouk.hrmsproject.bll.concretes;

import com.bgouk.hrmsproject.bll.abstracts.JobSeekerService;
import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.bll.validationRules.JobSeekerValidatorService;
import com.bgouk.hrmsproject.core.adapters.UserRealCheckService;
import com.bgouk.hrmsproject.core.utils.business.BusinessEngine;
import com.bgouk.hrmsproject.core.utils.result.ErrorResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.core.utils.result.SuccessResult;
import com.bgouk.hrmsproject.dal.abstracts.JobSeekerRepository;
import com.bgouk.hrmsproject.dal.abstracts.UserDao;
import com.bgouk.hrmsproject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerManager extends UserManager<JobSeeker> implements JobSeekerService {

    private final JobSeekerRepository jobSeekerDao;
    private final JobSeekerValidatorService jobSeekerValidatorService;
    private final UserRealCheckService userRealCheckService;

    @Autowired
    public JobSeekerManager(UserDao<JobSeeker> userDao, JobSeekerValidatorService jobSeekerValidatorService, UserRealCheckService userRealCheckService) {
        super(userDao);
        jobSeekerDao = (JobSeekerRepository) userDao;
        this.jobSeekerValidatorService = jobSeekerValidatorService;
        this.userRealCheckService = userRealCheckService;
    }

    @Override
    public Result add(JobSeeker user) {
        Result result = BusinessEngine.run(jobSeekerValidatorService.jobSeekerNullCheck(user),jobSeekerValidatorService.nationalIdValid(user.getNationalIdentity()),isNationalIdentityExists(user.getNationalIdentity()),userRealCheckService.check(Long.parseLong(user.getNationalIdentity()),user.getFirstName(),user.getLastName(),user.getBirthDate()));

        if (!result.isSuccess()){
            return result;
        }
        return super.add(user);
    }
    private Result isNationalIdentityExists(String nationalIdentity){
        if (jobSeekerDao.findByNationalIdentity(nationalIdentity).isPresent()){
            return new ErrorResult(Messages.nationalIdentityExist);
        }
        return new SuccessResult();
    }

}
