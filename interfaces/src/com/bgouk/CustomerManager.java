package com.bgouk;

public class CustomerManager {

    private final Logger[] loggers;

    public CustomerManager(Logger... logger){
        this.loggers = logger;
    }

    public void add(Customer customer){
        System.out.println("Müşteri eklendi " + customer.getFirstName());
        Utils.runLoggers(loggers,customer.getFirstName() + " isimli müşteri eklendi");

    }
    public void delete(Customer customer){
        System.out.println("Müşteri silindi " + customer.getFirstName());
        Utils.runLoggers(loggers, customer.getFirstName() + " isimli müşteri silindi");


    }
}
