package com.example.demo.service;

import com.example.demo.mapper.addLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class addLogService {

    @Autowired
    private addLogMapper addLogMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addLog(String nickName){
        if (getParams(nickName) == false){
            logger.warn("getLog方法参数错误");
            return false;
        }

        Date date = new Date();

        //logger.warn("nickname 为 " + nickName);

        int res = addLogMapper.addLog(nickName,date);
        if (res == 0){
            logger.warn("addLog方法添加打点失败");
            return false;
        }

        return true;

    }

    public boolean getParams(String nickName){
        if (nickName == null || nickName.length() > 40){
            return false;
        }

        return true;
    }
}
