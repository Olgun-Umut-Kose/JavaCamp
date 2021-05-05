package com.bgouk.Abstract;

import com.bgouk.Concrete.Entities.Customer;

import java.net.MalformedURLException;

public abstract class BaseCustomerManager implements ICustomerService {
    @Override
    public void Save(Customer customer) throws Exception {
        System.out.println("Saved DB " + customer.getFirstName());
    }
}
