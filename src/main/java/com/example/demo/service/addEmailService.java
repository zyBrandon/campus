package com.example.demo.service;

import com.example.demo.mapper.addEmailMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class addEmailService {

    @Autowired
    private addEmailMapper addEmailMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addEmail(String email_num,String email_title,String email_content){
        if (getParams(email_num, email_title, email_content) == false){
            logger.warn("addEmail参数错误");
            return false;
        }

        Date email_time = new Date();
        int res = addEmailMapper.addEmail(email_num,email_title,email_content,email_time);
        if (res == 0){
            logger.warn("addEmail入库失败");
            return false;
        }
        return true;

    }
    public boolean getParams(String email_num,String email_title,String email_content){
        if (email_num == null || email_num.length() > 30 || email_title == null || email_content == null){
            return false;
        }

        return true;
    }
}
