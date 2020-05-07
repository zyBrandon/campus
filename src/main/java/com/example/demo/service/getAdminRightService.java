package com.example.demo.service;

import com.example.demo.mapper.getAdminRightMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class getAdminRightService {

    @Autowired
    private getAdminRightMapper getAdminRightMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getAdminRight(String admin_name){
        if (getParams(admin_name) == false){
            logger.warn("getAdminRight参数错误");
            return null;
        }

        String res = getAdminRightMapper.getAdminRight(admin_name);
        if (res == null){
            logger.warn("getAdminRight方法获取数据错误");
            return null;
        }

        return res;
    }

    public boolean getParams(String nickName){
        if (nickName == null || nickName.length() > 40){
            return false;
        }

        return true;
    }

}
