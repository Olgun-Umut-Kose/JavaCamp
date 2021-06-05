package com.bgouk.hrmsproject.bll.concretes;

import com.bgouk.hrmsproject.bll.abstracts.JobAdvertisementService;
import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.core.utils.result.*;
import com.bgouk.hrmsproject.dal.abstracts.JobAdvertisementDao;
import com.bgouk.hrmsproject.entities.builder.JobAdvertisementDetailBuilder;
import com.bgouk.hrmsproject.entities.concretes.JobAdvertisement;
import com.bgouk.hrmsproject.entities.dtos.JobAdvertisementDetailDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private final JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public DataResult<List<JobAdvertisementDetailDto>> getAllActive() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findByIsActivatedIsTrueAndAppealDeadlineAfterOrAppealDeadlineNull(LocalDateTime.now());
        return new SuccessDataResult<List<JobAdvertisementDetailDto>>(toDto(jobAdvertisements),Messages.jobAdvertisementListed);

    }

    @Override
    public DataResult<List<JobAdvertisementDetailDto>> getAllActiveSortByCreatedDate() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findByIsActivatedIsTrueAndAppealDeadlineAfterOrAppealDeadlineNullOrderByCreatedDateDesc(LocalDateTime.now());
        return new SuccessDataResult<List<JobAdvertisementDetailDto>>(toDto(jobAdvertisements),Messages.jobAdvertisementListed);

    }

    @Override
    public DataResult<List<JobAdvertisementDetailDto>> getAllActiveByEmployer(int employerId) {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findByAndEmployer_IdAndIsActivatedIsTrueAndAppealDeadlineAfterOrAppealDeadlineNull(LocalDateTime.now(),employerId);
        return new SuccessDataResult<List<JobAdvertisementDetailDto>>(toDto(jobAdvertisements),Messages.jobAdvertisementListed);

    }

    @Override
    public DataResult<List<JobAdvertisementDetailDto>> getAllActiveByEmployerSortByCreatedDate(int employerId) {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findByAndEmployer_IdAndIsActivatedIsTrueAndAppealDeadlineAfterOrAppealDeadlineNullOrderByCreatedDateDesc(LocalDateTime.now(),employerId);
        return new SuccessDataResult<List<JobAdvertisementDetailDto>>(toDto(jobAdvertisements),Messages.jobAdvertisementListed);

    }


    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.jobAdvertisementAdded);
    }

    @Override
    public Result toggleActive(int jobAdvertisementId) throws NoSuchFieldException, IllegalAccessException {
        Optional<JobAdvertisement> nullableJobAdvertisement = jobAdvertisementDao.findById(jobAdvertisementId);
        if (nullableJobAdvertisement.isEmpty()){
            return new ErrorResult(Messages.jobAdvertisementNotFound);
        }
        nullableJobAdvertisement.get().setActivated(!nullableJobAdvertisement.get().isActivated());
        jobAdvertisementDao.save(nullableJobAdvertisement.get());
        String activated = (String)Messages.class.getDeclaredField("jobAdvertisementActivated"+nullableJobAdvertisement.get().isActivated()).get(Messages.class);

        return new SuccessResult(Messages.jobAdvertisementActivatedToggled+activated);
    }

    private List<JobAdvertisementDetailDto> toDto(List<JobAdvertisement> jobAdvertisements){
        return jobAdvertisements.stream().map((x) -> JobAdvertisementDetailBuilder.startBuild().setEmployerName(x.getEmployer().getCompanyName()).setActivated(x.isActivated()).setAppealDeadline(x.getAppealDeadline()).setJobDescription(x.getJobDescription()).setJobTitle(x.getJobPosition().getTitle()).setCityName(x.getCity().getName()).setMaxSalary(x.getMaxSalary()).setMinSalary(x.getMinSalary()).setQuota(x.getQuota()).setUpdatedDate(x.getUpdatedDate()).build()).toList();

    }

}
