package com.bgouk.Bll.Concrete;

import com.bgouk.Bll.Abstract.IUserService;
import com.bgouk.Core.Entities.Concrete.User;
import com.bgouk.Dal.Abstract.IUserDao;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements IUserService {
    private final IUserDao _dao;

    public UserManager(IUserDao dao) {
        _dao = dao;
    }

    @Override
    public void Add(User user) {
        System.out.println(UserValid(user));
        if(UserValid(user) && !isEmailExists(user.getEmail()))
        {
            _dao.Add(user);
            System.out.println("kayıt başarılı");
            return;
        }
        System.out.println("kurallara uymayan kullanıcı");


    }

    @Override
    public void Update(User user) {
        if (UserValid(user) ) _dao.Update(user);
    }

    @Override
    public void Delete(User user) {
        _dao.Delete(user);
    }

    @Override
    public User GetById(int id) {
        return _dao.GetById(id);
    }

    @Override
    public User GetByMail(String mail) {
        return _dao.GetByMail(mail);
    }

    @Override
    public boolean isEmailExists(String mail) {
        return _dao.isEmailExists(mail);
    }

    @Override
    public boolean isPasswordExists(String pass) {
        return _dao.isPasswordExists(pass);
    }

    @Override
    public ArrayList<User> GetAll() {
        return _dao.GetAll();
    }

    private boolean EmailValid(String email){
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
    private boolean UserValid(User user){
        return EmailValid(user.getEmail()) && user.getPassword().length() > 6 && user.getFirstName().length() > 2 && user.getLastName().length() > 2;
    }
}
