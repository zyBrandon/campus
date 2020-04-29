package com.example.demo.service;

import com.example.demo.mapper.getAdminLoginMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class getAdminLoginService {

    @Autowired
    private getAdminLoginMapper getAdminLoginMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean getAdminLogin(String admin_name,String admin_pass){
        if (getParams(admin_name, admin_pass) == false){
            logger.warn("getAdminLogin参数错误");
            return false;
        }

        int res = getAdminLoginMapper.getAdminLogin(admin_name, admin_pass);
        if (res == 0){
            return false;
        }

        return true;


    }

    public boolean getParams(String admin_name,String admin_pass){
        if (admin_name == null || admin_pass == null || admin_name.length() > 20 || admin_pass.length() > 20){
            return false;
        }

        return true;
    }
}
