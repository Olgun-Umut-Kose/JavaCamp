package com.bgouk.hrmsproject.api.controller;

import com.bgouk.hrmsproject.bll.abstracts.JobPositionService;
import com.bgouk.hrmsproject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public List<JobPosition> getAll(){
        return jobPositionService.getAll();

    }
    @PostMapping("/add")
    public void add(@RequestBody JobPosition jobPosition){
        jobPositionService.add(jobPosition);
    }
}
