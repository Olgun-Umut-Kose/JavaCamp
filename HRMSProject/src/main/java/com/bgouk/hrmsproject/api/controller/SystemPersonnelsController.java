package com.bgouk.hrmsproject.api.controller;

import com.bgouk.hrmsproject.bll.abstracts.SystemPersonnelService;
import com.bgouk.hrmsproject.dal.abstracts.SystemPersonnelDao;
import com.bgouk.hrmsproject.entities.concretes.SystemPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@RestController
@RequestMapping("/api/systempersonnels")
public class SystemPersonnelsController {
    @Autowired
    private SystemPersonnelService systemPersonnelService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody SystemPersonnel systemPersonnel){
        systemPersonnelService.add(systemPersonnel);
        return ResponseEntity.ok().build();
    }

}
