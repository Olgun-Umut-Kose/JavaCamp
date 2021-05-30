package com.bgouk.hrmsproject.bll.abstracts;

import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.abstracts.User;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.List;
import java.util.Optional;

public interface UserService<T extends User> {


    DataResult<Optional<T>> getByEmail(String email);
    DataResult<List<T>> getAll();
    Result add(T user);



}
