package com.bgouk.Dal.Abstract;

import com.bgouk.Core.Entities.Concrete.User;

import java.util.ArrayList;
import java.util.SplittableRandom;

public interface IUserDao {
    void Add(User user);
    void Update(User user);
    void Delete(User user);
    User GetById(int id);
    User GetByMail(String mail);
    boolean isEmailExists(String mail);
    boolean isPasswordExists(String pass);
    ArrayList<User> GetAll();

}
