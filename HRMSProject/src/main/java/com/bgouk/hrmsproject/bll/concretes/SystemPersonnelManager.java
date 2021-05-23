package com.bgouk.hrmsproject.bll.concretes;

import com.bgouk.hrmsproject.bll.abstracts.SystemPersonnelService;
import com.bgouk.hrmsproject.dal.abstracts.SystemPersonnelDao;
import com.bgouk.hrmsproject.entities.concretes.SystemPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

    @Autowired
    private SystemPersonnelDao systemPersonnelDao;




    @Override
    public void add(SystemPersonnel systemPersonnel) {
        systemPersonnelDao.save(systemPersonnel);
    }
}
