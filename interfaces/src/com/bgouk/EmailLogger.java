package com.bgouk;

public class EmailLogger implements Logger{
    @Override
    public void log(String message) {
        System.out.println("Email e loglandı " + message);
    }
}
