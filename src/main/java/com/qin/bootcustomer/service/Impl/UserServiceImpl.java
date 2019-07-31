package com.qin.bootcustomer.service.Impl;

import com.qin.bootcustomer.po.User;
import com.qin.bootcustomer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qin.bootcustomer.dao.UserDao;

/**
 * @program: BootCustomer
 * @description: 实现接口
 * @author: qin
 * @create: 2019-07-17 14:53
 **/
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userdao;
    public User findUser(String username, String password) {
        User user = this.userdao.findUser(username, password);
        return user;
    }
}
