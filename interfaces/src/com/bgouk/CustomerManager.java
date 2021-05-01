package com.bgouk;

public class CustomerManager {

    private final Logger logger;

    public CustomerManager(Logger logger){
        this.logger = logger;
    }

    public void add(Customer customer){
        System.out.println("Müşteri eklendi " + customer.getFirstName());
        logger.log(customer.getFirstName() + " isimli müşteri eklendi");
    }
    public void delete(Customer customer){
        System.out.println("Müşteri silindi " + customer.getFirstName());
        logger.log(customer.getFirstName() + " isimli müşteri silindi");
    }
}
