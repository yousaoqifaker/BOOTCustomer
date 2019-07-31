package com.qin.bootcustomer.dao;

import com.qin.bootcustomer.po.BaseDict;

import java.util.List;

/**
* @Description: 数据字典接口
* @Param:
* @return:
* @Author: Qin
* @Date: 2019/7/18
*/
public interface BaseDictDao {
    public List<BaseDict>selectBaseDictByTypeCode(String typecode);
}
