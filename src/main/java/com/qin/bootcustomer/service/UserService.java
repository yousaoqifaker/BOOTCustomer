package com.qin.bootcustomer.service;

import com.qin.bootcustomer.po.User;

public interface UserService {
    /**
     * 查找用户
     * @param username
     * @param password
     * @return
     */
    public User findUser(String username, String password);
}
