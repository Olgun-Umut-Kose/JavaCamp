package com.bgouk;

import com.bgouk.Concrete.Adapters.MernisAdapter;
import com.bgouk.Concrete.Entities.Customer;
import com.bgouk.Concrete.NeroCustomerManager;
import com.bgouk.Concrete.StarbucksCustomerManager;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        NeroCustomerManager neroCustomerManager = new NeroCustomerManager();
        Customer customer = new Customer(2,"engin","demiroğ",LocalDate.of(1985,1,6),"28861499108");

        neroCustomerManager.Save(customer);

        StarbucksCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(new MernisAdapter());
        starbucksCustomerManager.Save(customer);

    }
}
