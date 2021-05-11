package com.bgouk.Dal.Concrete.InMemory;

import com.bgouk.Core.Entities.Concrete.User;
import com.bgouk.Dal.Abstract.IUserDao;

import java.util.ArrayList;

public class InMemoryUserDao implements IUserDao {

    private ArrayList<User> users = new ArrayList<>();

    @Override
    public void Add(User user) {
        users.add(user);
    }

    @Override
    public void Update(User user) {
        User tempUser = GetById(user.getId());
        tempUser.setEmail(user.getEmail());
        tempUser.setFirstName(user.getFirstName());
        tempUser.setLastName(user.getLastName());
        tempUser.setPassword(user.getPassword());
        tempUser.setVerificationCode(user.getVerificationCode());
        tempUser.setVerify(user.isVerify());

    }

    @Override
    public void Delete(User user) {
        User tempUser = GetById(user.getId());
        users.remove(tempUser);
    }

    @Override
    public User GetById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    @Override
    public User GetByMail(String mail) {
        return users.stream().filter(u -> u.getEmail().equals(mail)).findFirst().get();
    }

    @Override
    public boolean isEmailExists(String mail) {
        return users.stream().anyMatch(u -> u.getEmail().equals(mail));
    }

    @Override
    public boolean isPasswordExists(String pass) {
        return users.stream().anyMatch(u -> u.getPassword().equals(pass));
    }

    @Override
    public ArrayList<User> GetAll() {
        return users;
    }
}
