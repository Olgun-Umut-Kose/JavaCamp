package com.bgouk.hrmsproject.bll.abstracts;

import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    DataResult<List<JobPosition>> getAll();
    Result add(JobPosition jobPosition);

}
