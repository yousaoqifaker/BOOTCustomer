package com.qin.bootcustomer.service;

import com.qin.bootcustomer.po.Customer;
import com.qin.bootcustomer.utils.Page;
import org.springframework.stereotype.Service;


public interface CustomerService {
    public Page<Customer>findCustomerList(Integer page,Integer rows,String custName,String custSource,String custcustIndustry,String custLevel);
}
