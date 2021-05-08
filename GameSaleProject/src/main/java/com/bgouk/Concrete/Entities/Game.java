package com.bgouk.Concrete.Entities;

import com.bgouk.Abstract.Entity;

import java.util.ArrayList;
import java.util.List;

public class Game extends Entity {

    private String name;
    private float price;
    private List<Campaign> campaigns = new ArrayList<Campaign>();

    public Game() {
    }

    public Game(int id, String name, float price, List<Campaign> campaigns) {
        super(id);
        this.name = name;
        this.price = price;
        this.setCampaigns(campaigns);
    }

    public Game(int id, String name, float price) {
        super(id);
        this.name = name;
        this.price = price;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }
}
