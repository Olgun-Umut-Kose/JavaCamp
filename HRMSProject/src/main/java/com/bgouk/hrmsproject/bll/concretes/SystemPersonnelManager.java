package com.bgouk.hrmsproject.bll.concretes;

import com.bgouk.hrmsproject.bll.abstracts.SystemPersonnelService;
import com.bgouk.hrmsproject.dal.abstracts.UserDao;
import com.bgouk.hrmsproject.entities.concretes.SystemPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemPersonnelManager extends UserManager<SystemPersonnel> implements SystemPersonnelService {

    @Autowired
    public SystemPersonnelManager(UserDao<SystemPersonnel> userDao) {
        super(userDao);

    }


}
