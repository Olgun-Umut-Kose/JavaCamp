package com.bgouk.hrmsproject.bll.concretes;

import com.bgouk.hrmsproject.bll.abstracts.UserService;
import com.bgouk.hrmsproject.bll.constant.Messages;
import com.bgouk.hrmsproject.core.utils.business.BusinessEngine;
import com.bgouk.hrmsproject.core.utils.result.*;
import com.bgouk.hrmsproject.dal.abstracts.UserDao;
import com.bgouk.hrmsproject.entities.abstracts.User;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class UserManager<T extends User> implements UserService<T>{

    private final UserDao<T> userDao;


    @Autowired
    public UserManager(UserDao<T> userDao) {
        this.userDao = userDao;
    }


    @Override
    public DataResult<List<T>> getAll() {
        return new SuccessDataResult<List<T>>(ImmutableList.copyOf(userDao.findAll().iterator()), Messages.userListed);
    }

    @Override
    public DataResult<Optional<T>> getByEmail(String email) { // deneme
        return new SuccessDataResult<Optional<T>>((Optional<T>) userDao.findByEmail(email));
    }

    @Override
    public Result add(T user) {
        Result result = BusinessEngine.run(emailExists(user.getEmail()));

        if (result.isSuccess()){
            userDao.save(user);
            return new SuccessResult(Messages.userAdded);
        }

        return result;

    }

    private Result emailExists(String email){
        if (userDao.findByEmail(email).isPresent()){
            return new ErrorResult(Messages.emailExist);
        }
        return new SuccessResult();
    }


}

