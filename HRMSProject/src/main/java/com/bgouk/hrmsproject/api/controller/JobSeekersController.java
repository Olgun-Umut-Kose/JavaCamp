package com.bgouk.hrmsproject.api.controller;

import com.bgouk.hrmsproject.bll.abstracts.JobSeekerService;
import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {
    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll(){
        return jobSeekerService.getAll();
    }
}
