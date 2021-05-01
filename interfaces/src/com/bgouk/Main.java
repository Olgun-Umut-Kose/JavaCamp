package com.bgouk;

public class Main {

    public static void main(String[] args) {

        CustomerManager customerManager = new CustomerManager(new EmailLogger());
        Customer customer = new Customer(1,"Engin","Demiroğ");
        customerManager.add(customer);
    }
}
