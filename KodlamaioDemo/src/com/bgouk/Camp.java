package com.bgouk;

import java.util.List;

public class Camp {
    int id;
    String name;
    List<Day> days;

    public Camp(int id, String name, List<Day> days) {
        this.id = id;
        this.name = name;
        this.days = days;
    }
}

        
