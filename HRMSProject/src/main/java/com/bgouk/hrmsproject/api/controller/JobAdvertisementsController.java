package com.bgouk.hrmsproject.api.controller;

import com.bgouk.hrmsproject.bll.abstracts.JobAdvertisementService;
import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.concretes.JobAdvertisement;
import com.bgouk.hrmsproject.entities.concretes.JobPosition;
import com.bgouk.hrmsproject.entities.dtos.JobAdvertisementDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

    private final JobAdvertisementService jobAdvertisementService;


    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getallactivated")
    public DataResult<List<JobAdvertisementDetailDto>> getAllActivated(){
        return jobAdvertisementService.getAllActive();

    }
    @GetMapping("/getallactivatedsortbycreateddate")
    public DataResult<List<JobAdvertisementDetailDto>> getAllActivatedSortByCreatedDate(){
        return jobAdvertisementService.getAllActiveSortByCreatedDate();

    }
    @GetMapping("/getallactivatedbyemployer")
    public DataResult<List<JobAdvertisementDetailDto>> getAllActivatedByEmployer(int employerId){
        return jobAdvertisementService.getAllActiveByEmployer(employerId);

    }
    @GetMapping("/getallactivatedbyemployersortbycreateddate")
    public DataResult<List<JobAdvertisementDetailDto>> getAllActivatedByEmployerSortByCreatedDate(int employerId){
        return jobAdvertisementService.getAllActiveByEmployerSortByCreatedDate(employerId);

    }
    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.add(jobAdvertisement);
    }
    @PostMapping("/toggle")
    public Result add(@RequestBody int jobAdvertisementId) throws NoSuchFieldException, IllegalAccessException {
        return jobAdvertisementService.toggleActive(jobAdvertisementId);
    }
}
