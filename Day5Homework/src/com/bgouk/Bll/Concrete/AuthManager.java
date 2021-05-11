package com.bgouk.Bll.Concrete;

import com.bgouk.Bll.Abstract.IAuthService;
import com.bgouk.Bll.Abstract.IUserService;
import com.bgouk.Core.Adapters.Concrete.GoogleAuthServiceAdapter;
import com.bgouk.Core.Entities.Concrete.User;

public class AuthManager implements IAuthService {
    private final IUserService userService;

    public AuthManager(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void SignUp(User user) {
        userService.Add(user);
        int random = (int) Math.floor(Math.random()*9999);
        String verificationCode = user.getFirstName().substring(0,1) + user.getId() + user.getLastName().substring(0,1)+random;
        user.setVerificationCode(verificationCode);

    }

    @Override
    public void SignIn(User user) {
        User tempUser = userService.GetByMail(user.getEmail());
        if (tempUser.isVerify())
        {
            if (userService.isEmailExists(user.getEmail()) && userService.isPasswordExists(user.getPassword()))
            {
                System.out.println("Giriş yapıldı bruh");
                return;
            }
            System.out.println("Email veya parola hatalı bruh");
            return;
        }
        System.out.println("Hesap doğrulanmamış bruh");
    }

    @Override
    public void SingInWithGoogle() {
        GoogleAuthServiceAdapter googleAuthServiceAdapter = new GoogleAuthServiceAdapter();
        User user = googleAuthServiceAdapter.Login();
        if (!userService.isEmailExists(user.getEmail())){
            userService.Add(user);
            user.setVerify(true);

        }
        user.setVerify(true);
        System.out.println("Google ile giriş başarılı");
    }

    @Override
    public void Verify(User user, String code) {
        User tempUser = userService.GetByMail(user.getEmail());
        if (tempUser.getVerificationCode().equals(code)){
            tempUser.setVerify(true);
            System.out.println("Doğrulama başarılı");
            return;
        }
        System.out.println("kod hatalı");
    }
}
