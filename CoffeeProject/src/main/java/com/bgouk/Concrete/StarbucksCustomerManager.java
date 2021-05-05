package com.bgouk.Concrete;

import com.bgouk.Abstract.BaseCustomerManager;
import com.bgouk.Abstract.ICustomerCheckService;
import com.bgouk.Abstract.ICustomerService;
import com.bgouk.Concrete.Entities.Customer;

import java.net.MalformedURLException;

public class StarbucksCustomerManager extends BaseCustomerManager {

    private ICustomerCheckService customerCheckService;

    public StarbucksCustomerManager(ICustomerCheckService customerCheckService) {
        this.customerCheckService = customerCheckService;
    }

    @Override
    public void Save(Customer customer) throws Exception {
        if (!customerCheckService.Verify(customer)){
            throw new Exception("Person Not Valid");
        }
        super.Save(customer);


    }

}
