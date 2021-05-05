package com.bgouk.Abstract;

import com.bgouk.Concrete.Entities.Customer;

import java.net.MalformedURLException;

public interface ICustomerService {
    void Save(Customer customer) throws Exception;
}
