package com.bgouk;

public class DayManager {
    public void addContent(Day day, Content content){
        day.contents.add(content);
    }
    public void deleteContent(Day day, Content content){
        day.contents.remove(content);
    }
}
