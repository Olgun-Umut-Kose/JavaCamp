package com.bgouk.hrmsproject.bll.abstracts;

import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.concretes.JobAdvertisement;
import com.bgouk.hrmsproject.entities.dtos.JobAdvertisementDetailDto;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisementDetailDto>> getAllActive();
    DataResult<List<JobAdvertisementDetailDto>> getAllActiveSortByCreatedDate();
    DataResult<List<JobAdvertisementDetailDto>> getAllActiveByEmployer(int employerId);
    DataResult<List<JobAdvertisementDetailDto>> getAllActiveByEmployerSortByCreatedDate(int employerId);
    Result add(JobAdvertisement jobAdvertisement);
    Result toggleActive(int jobAdvertisementId) throws NoSuchFieldException, IllegalAccessException;

}
