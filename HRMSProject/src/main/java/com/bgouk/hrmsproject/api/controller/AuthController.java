package com.bgouk.hrmsproject.api.controller;

import com.bgouk.hrmsproject.bll.abstracts.auth.AuthService;
import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.concretes.JobSeeker;
import com.bgouk.hrmsproject.entities.dtos.RegisterForEmployerDto;
import com.bgouk.hrmsproject.entities.dtos.RegisterForJobSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/jobseeker/register")
    public Result jobSeekerRegister(@RequestBody RegisterForJobSeekerDto registerForJobSeekerDto){
        return authService.jobSeekerRegister(registerForJobSeekerDto);
    }
    @PostMapping("/employer/register")
    public Result employerRegister(@RequestBody RegisterForEmployerDto registerForEmployerDto){
        return authService.employerRegister(registerForEmployerDto);
    }
    @GetMapping("/verify")
    public Result verify(int userId,String code) throws NoSuchFieldException, IllegalAccessException {
        return authService.verify(userId, code);
    }
}
