package com.bgouk.Bll.Abstract;

import com.bgouk.Core.Entities.Concrete.User;

import java.beans.VetoableChangeListenerProxy;
import java.nio.charset.CoderMalfunctionError;

public interface IAuthService {
    void SignUp(User user);
    void SignIn(User user);
    void SingInWithGoogle();
    void Verify(User user, String code);
}
