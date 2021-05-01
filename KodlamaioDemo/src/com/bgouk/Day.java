package com.bgouk;

import java.util.List;

public class Day {

    int id;
    String name;
    List<Content> contents;

    public Day(int id, String name, List<Content> contents){
        this.id = id;
        this.name = name;
        this.contents = contents;
    }

}
