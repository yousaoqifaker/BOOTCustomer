package com.qin.bootcustomer.web.controller;

import com.qin.bootcustomer.po.BaseDict;
import com.qin.bootcustomer.po.Customer;
import com.qin.bootcustomer.service.BaseDictService;
import com.qin.bootcustomer.service.CustomerService;
import com.qin.bootcustomer.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: BootCustomer
 * @description: 客户管理控制类
 * @author: qin
 * @create: 2019-07-22 12:21
 **/
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BaseDictService baseDictService;
    @Value("${customer.from.type}")
    private String FROM_TYPE;
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;
    @RequestMapping("/customer/list.action")
    public String list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows,
                       String custName, String custSource, String custIndustry, String custLevel, Model model){
        System.out.println("controller"+custName+custSource+custIndustry+custLevel);
        Page<Customer>customers=customerService.findCustomerList(page,rows,custName,custSource,custIndustry,custLevel);
        model.addAttribute("page",customers);
        List<BaseDict>fromType=baseDictService.findBaseDictByTypeCode(FROM_TYPE);
        List<BaseDict>industryType=baseDictService.findBaseDictByTypeCode(INDUSTRY_TYPE);
        List<BaseDict>levelType=baseDictService.findBaseDictByTypeCode(LEVEL_TYPE);
        System.out.println(fromType+"\n"+industryType+"\n"+levelType+"\n");
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);
        model.addAttribute("custName",custName);
        model.addAttribute("custSource",custSource);
        model.addAttribute("custIndustry",custIndustry);
        model.addAttribute("custLevel",custLevel);
        return "customer";

    }
}
