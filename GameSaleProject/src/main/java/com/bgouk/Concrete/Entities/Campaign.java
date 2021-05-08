package com.bgouk.Concrete.Entities;

import com.bgouk.Abstract.Entity;
import com.bgouk.Abstract.Person;

public class Campaign extends Entity {
    private String name;
    private int discount;

    public Campaign(int id, String name, int discount) {
        super(id);
        this.name = name;
        this.discount = discount;
    }

    public Campaign() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
