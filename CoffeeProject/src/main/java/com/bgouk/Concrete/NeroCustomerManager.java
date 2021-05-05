package com.bgouk.Concrete;

import com.bgouk.Abstract.BaseCustomerManager;
import com.bgouk.Concrete.Entities.Customer;

import java.util.Base64;

public class NeroCustomerManager extends BaseCustomerManager {
    @Override
    public void Save(Customer customer) throws Exception {
        super.Save(customer);
    }
}
