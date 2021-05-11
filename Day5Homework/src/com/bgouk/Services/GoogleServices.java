package com.bgouk.Services;

import java.util.ArrayList;

public class GoogleServices {

    public GoogleUser GetGmail(){
        Gmail gmail =new Gmail();
        ArrayList<GoogleUser> googleUsers = gmail.GetUser();
        int randomIndex = (int)Math.floor(Math.random()*googleUsers.stream().count()-1);
        return googleUsers.get(randomIndex);
    }
}
