package com.example.demo.service;

import com.example.demo.mapper.getTodayLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class getTodayLogService {

    @Autowired
    private getTodayLogMapper getTodayLogMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public int getTodayLog(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式


        String hehe = dateFormat.format( date );
        System.out.println(hehe);
        int res = getTodayLogMapper.getTodayLog(hehe);

        return res;

    }
}
