package com.bgouk;

import com.bgouk.Concrete.Adapters.MernisAdapter;
import com.bgouk.Concrete.Entities.Customer;
import com.bgouk.Concrete.NeroCustomerManager;
import com.bgouk.Concrete.StarbucksCustomerManager;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        NeroCustomerManager neroCustomerManager = new NeroCustomerManager();
        Customer customer = new Customer(1,"deneme","deneme",LocalDate.of(1999,12,12),"12465454");

        neroCustomerManager.Save(customer);

        StarbucksCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(new MernisAdapter());
        starbucksCustomerManager.Save(customer);

    }
}
