package com.example.demo.service;

import com.example.demo.mapper.addAddressMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addAddressService {

    @Autowired
    private addAddressMapper addAddressMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addAddress(String address,String user_name,String name,String longtitude,String latitude){
        if (getParams(address, user_name,name,longtitude,latitude) == false){
            logger.warn("addAddress方法参数错误");
            return false;
        }

        int res = addAddressMapper.addAddress(address, user_name,name,longtitude,latitude);
        if (res == 0){
            logger.warn("addAddress方法添加失败");
            return false;
        }

        return true;

    }

    public boolean getParams(String address,String user_name,String name,String longtitude,String latitude){
        if (address == null || user_name == null || name == null || longtitude == null || latitude == null){
            return false;
        }

        return true;
    }
}
