package com.bgouk;

public class CampManager {
    public void addDay(Camp camp, Day day){
        camp.days.add(day);
    }
    public void deleteDay(Camp camp, Day day){
        camp.days.remove(day);
    }
}
