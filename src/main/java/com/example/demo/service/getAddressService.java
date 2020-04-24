package com.example.demo.service;

import com.example.demo.mapper.getAddressMapper;
import com.example.demo.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class getAddressService {

    @Autowired
    private getAddressMapper getAddressMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ArrayList<Address> getAddress(String user_name){
        if (getParams(user_name) == false){
            logger.warn("getaddress接口参数错误");
            return null;
        }

        ArrayList<Address> res = getAddressMapper.getAddress(user_name);
        if (res == null){
            logger.warn("getAddress获取数据为空");

        }

        return res;

    }

    public boolean getParams(String nickName){
        if (nickName == null){
            return false;
        }

        return true;
    }
}
