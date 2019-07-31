package com.qin.bootcustomer.web.controller;

import com.qin.bootcustomer.po.User;
import com.qin.bootcustomer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @program: BootCustomer
 * @description: 测试
 * @author: qin
 * @create: 2019-07-17 13:18
 **/
@Controller
public class controller {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login.action",method = RequestMethod.POST)
    public String login(String usercode, String password, Model model, HttpSession session){
        User user = userService.findUser(usercode, password);
        System.out.println(user);
        if (user!=null){
            session.setAttribute("USER_SESSION",user);
            return "customer";
        }
        model.addAttribute("msg","账户或密码出错，请重新输入");
        return "login";
    }
    @RequestMapping("toCustomer.action")
    public String toCustomer(){
        return "customer";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login.action";
    }
    @RequestMapping(value = "/login.action",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }
}
