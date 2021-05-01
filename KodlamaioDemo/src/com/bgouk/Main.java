package com.bgouk;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Content content1 = new Content(1, "Ders Programı", "Program");
        Content content2 = new Content(2, "Ödev1", "Ödevler");
        Content content3 = new Content(3, "Ödev2", "Ödevler");
        Content content4 = new Content(4, "Ders Programı", "Program");
        Content content5 = new Content(5, "Ödev1", "Ödevler");
        Content content6 = new Content(6, "Ödev2", "Ödevler");

        Content[] contents1 = {
                content1, content2,cntent3
        };
        Content[] contents2 = {
                content4, content5, content6
        };

        Day day1 = new Day(1, "Gün1", new LinkedList<Content>(Arrays.stream(contents1).toList()));
        Day day2 = new Day(2, "Gün2", new LinkedList<Content>(Arrays.stream(contents2).toList()));

        Day[] days = {
                day1, day2
        };

        Camp camp = new Camp(1, "Yazılım Geliştirici Yetiştirme Kampı", new LinkedList<Day>(Arrays.stream(days).toList()));

        PrintCamp(camp);

        CampManager campManager = new CampManager();
        DayManager dayManager = new DayManager();
        ContentManager contentManager = new ContentManager();

        Day day3 = new Day(3 , "Gün3", new LinkedList<Content>(Arrays.stream(contents1).toList()));

        campManager.addDay(camp, day3);

        PrintCamp(camp);
        Content content7 = new Content(7, "Ödev3", "Ödevler");
        dayManager.addContent(day3, content7);
        PrintCamp(camp);
        contentManager.switchRead(content7);
        PrintCamp(camp);

    }

    private static void PrintCamp(Camp camp) {
        System.out.println(camp.name);
        System.out.println("*****************************************");
        for (Day day:camp.days) {
            System.out.println(day.name);

            for (Content content:day.contents) {
                System.out.println(content.title + ": Read: " + content.isRead);

            }
            System.out.println("*****************************************");
        }
        System.out.println();
    }
}
