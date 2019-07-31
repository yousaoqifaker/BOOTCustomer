package com.qin.bootcustomer.dao;

import com.qin.bootcustomer.po.Customer;

import java.util.List;

/**
 * @program: BootCustomer
 * @description: 接口
 * @author: qin
 * @create: 2019-07-18 16:59
 **/

public interface CustomerDao {
    /**
     * 查询客户
     * @param customer
     * @return
     */
    public List<Customer>selectCustomerList(Customer customer);

    /**
     * 查询总数
     * @param customer
     * @return
     */
    public Integer selectCustomerListCount(Customer customer);
}
