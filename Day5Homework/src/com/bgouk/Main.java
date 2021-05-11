package com.bgouk;

import com.bgouk.Bll.Concrete.AuthManager;
import com.bgouk.Bll.Concrete.UserManager;
import com.bgouk.Core.Entities.Concrete.User;
import com.bgouk.Dal.Concrete.InMemory.InMemoryUserDao;

public class Main {

    public static void main(String[] args) {
	// write your code here
        User user = new User(1,"deneme","soyad","deneme@deneme.deneme","1234567");
        UserManager userManager = new UserManager(new InMemoryUserDao());
        AuthManager authManager = new AuthManager(userManager);
        authManager.SignUp(user);
        authManager.Verify(user, user.getVerificationCode());
        authManager.SignIn(user);


    }
}
