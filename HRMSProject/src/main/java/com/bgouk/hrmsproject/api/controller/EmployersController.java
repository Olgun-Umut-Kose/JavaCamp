package com.bgouk.hrmsproject.api.controller;

import com.bgouk.hrmsproject.bll.abstracts.EmployerService;
import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.entities.concretes.Employer;
import com.bgouk.hrmsproject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    private final EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return employerService.getAll();
    }
}
