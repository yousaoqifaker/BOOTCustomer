package com.qin.bootcustomer.service.Impl;


import com.qin.bootcustomer.dao.CustomerDao;
import com.qin.bootcustomer.po.Customer;
import com.qin.bootcustomer.service.CustomerService;
import com.qin.bootcustomer.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: BootCustomer
 * @description: 客户管理
 * @author: qin
 * @create: 2019-07-22 11:24
 **/
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    public Page<Customer> findCustomerList(Integer page, Integer rows, String custName, String custSource, String custcustIndustry, String custLevel) {
        Customer customer=new Customer();
        if (StringUtils.isNotBlank(custName)){
            customer.setCust_name(custName);
        }
        if (StringUtils.isNotBlank(custSource)){
            customer.setCust_source(custSource);
        }
        if (StringUtils.isNotBlank(custcustIndustry)){
            customer.setCust_industry(custcustIndustry);
        }
        if (StringUtils.isNotBlank(custLevel)){
            customer.setCust_level(custLevel);
        }
        customer.setStart((page-1)*rows);
        customer.setRows(rows);
        List<Customer>customers=customerDao.selectCustomerList(customer);
        Integer count=customerDao.selectCustomerListCount(customer);
        System.out.println(count);
        Page<Customer>result=new Page<Customer>();
        result.setPage(page);
        result.setRows(customers);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }
}
