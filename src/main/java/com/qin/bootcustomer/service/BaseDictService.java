package com.qin.bootcustomer.service;

import com.qin.bootcustomer.po.BaseDict;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BaseDictService {
    public List<BaseDict>findBaseDictByTypeCode(String typecode);
}
