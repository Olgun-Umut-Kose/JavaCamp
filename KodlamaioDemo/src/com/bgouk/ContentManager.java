package com.bgouk;

public class ContentManager {
    public void switchRead(Content content){
        content.isRead = !content.isRead;
    }

    public void changeTitle(Content content, String title){
        content.title = title;
    }
}
