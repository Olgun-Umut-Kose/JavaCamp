package com.bgouk;

public class UserManager {

    public void signIn(User user){
        System.out.println(user.getFirtName() + " isimli kullanıcı giriş yaptı");
    }
    public void signOut(User user){
        System.out.println(user.getFirtName() + " isimli kullanıcı çıkış yaptı");
    }

    public void signUp(User user){
        System.out.println(user.getFirtName() + " isimli kullanıcı kayıt oldu");
    }
}
