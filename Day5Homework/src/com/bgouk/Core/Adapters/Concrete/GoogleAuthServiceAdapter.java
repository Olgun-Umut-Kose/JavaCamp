package com.bgouk.Core.Adapters.Concrete;

import com.bgouk.Core.Adapters.Abstract.IThirdPartyAuthService;
import com.bgouk.Core.Entities.Concrete.User;
import com.bgouk.Services.GoogleServices;
import com.bgouk.Services.GoogleUser;

public class GoogleAuthServiceAdapter implements IThirdPartyAuthService {
    @Override
    public User Login() {
        GoogleServices googleServices = new GoogleServices();
        GoogleUser googleUser = googleServices.GetGmail();
        return new User(15,googleUser.getFirstName(),googleUser.getLastName(),googleUser.getEmail(),googleUser.getPassword());
    }
}
