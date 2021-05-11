package com.bgouk.Services;

import java.util.ArrayList;

public class Gmail {

    public ArrayList<GoogleUser> GetUser()
    {
        ArrayList<GoogleUser> googleUsers = new ArrayList<>();
        googleUsers.add(new GoogleUser("dneeme","soyad","fhjfhdj@gmail.com","1234567"));
        googleUsers.add(new GoogleUser("gydugıgh","sokhjkghkyad","kkkgk@gmail.com","1234567"));
        googleUsers.add(new GoogleUser("dnejhkghkkgheme","soyjhkkkad","fhjfhjkghkkghhdj@gmail.com","1234567"));
        googleUsers.add(new GoogleUser("jhkghkkg","ghkkkjh","kghjkgk@gmail.com","1234567"));
        return googleUsers;

    }

}
