package com.bgouk;

public class SmsLogger implements Logger{
    @Override
    public void log(String message) {
        System.out.println("Sms e loglandı " + message);
    }
}
