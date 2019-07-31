package com.qin.bootcustomer.dao;

import com.qin.bootcustomer.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * @program: BootCustomer
 * @description: DAO层
 * @author: qin
 * @create: 2019-07-17 14:41
 **/

public interface UserDao {
    public User findUser(@Param("usercode") String usercode,@Param("password") String password);
}
