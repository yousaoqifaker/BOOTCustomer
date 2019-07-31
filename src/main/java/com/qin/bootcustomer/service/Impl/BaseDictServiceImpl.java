package com.qin.bootcustomer.service.Impl;

import com.qin.bootcustomer.dao.BaseDictDao;
import com.qin.bootcustomer.po.BaseDict;
import com.qin.bootcustomer.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: BootCustomer
 * @description: 数据字典接口实现类
 * @author: qin
 * @create: 2019-07-22 10:52
 **/
@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    private BaseDictDao baseDictDao;
    public List<BaseDict> findBaseDictByTypeCode(String typecode) {
        List<BaseDict>list=baseDictDao.selectBaseDictByTypeCode("001");
        System.out.println(list+"service");
        return baseDictDao.selectBaseDictByTypeCode(typecode);
    }
}
