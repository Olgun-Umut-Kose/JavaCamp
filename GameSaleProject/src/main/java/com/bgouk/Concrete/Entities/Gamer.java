package com.bgouk.Concrete.Entities;

import com.bgouk.Abstract.Person;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gamer extends Person {


    private float wallet;
    private List<Campaign> campaigns = new ArrayList<Campaign>();

    public Gamer() {
    }

    public Gamer(int id,String nationalityId, String firstName, String lastName, LocalDate dateOfBirth,  float wallet, List<Campaign> campaigns) {
        super(id,nationalityId, firstName, lastName, dateOfBirth);
        this.wallet = wallet;
        this.setCampaigns(campaigns);
    }

    public Gamer(int id,String nationalityId, String firstName, String lastName, LocalDate dateOfBirth, float wallet) {
        super(id,nationalityId, firstName, lastName, dateOfBirth);
        this.wallet = wallet;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }
}
