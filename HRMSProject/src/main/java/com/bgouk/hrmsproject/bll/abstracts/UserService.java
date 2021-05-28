package com.bgouk.hrmsproject.bll.abstracts;

import com.bgouk.hrmsproject.core.utils.result.DataResult;
import com.bgouk.hrmsproject.core.utils.result.Result;
import com.bgouk.hrmsproject.entities.abstracts.User;

import java.util.List;
import java.util.Optional;

public interface UserService<T extends User> {

    DataResult<Optional<T>> getById(int id);
    DataResult<List<T>> getAll();
    Result add(T user);


}
