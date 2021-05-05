package com.bgouk.Abstract;

import com.bgouk.Concrete.Entities.Customer;

import java.net.MalformedURLException;

public interface ICustomerCheckService {
    boolean Verify(Customer customer) throws MalformedURLException;
}
