package com.example.demo.controller;

import com.example.demo.service.getAllLogService;
import com.example.demo.service.getLoginRedisService;
import com.example.demo.service.getTodayLogService;
import com.example.demo.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class GetDoLogCountController {

    public static final String todayNum = "todayNum";
    public static final String allNum = "allNum";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private getTodayLogService getTodayLogSerive;

    @Autowired
    private getLoginRedisService getLoginRedisService;

    @Autowired
    private getAllLogService getAllLogService;

    @RequestMapping(value = "/getdolog",method = RequestMethod.GET)
    public ApiResult getdolog(@RequestParam("nickName") String nickName){

        HashMap res = new HashMap();

        //判断是否登录用户
        boolean onlineRes = getLoginRedisService.getUserLand(nickName);
        if (onlineRes == false){
            logger.warn("该用户未登录");
            return ApiResult.success(20003,"用户未登录","");
        }

        //获取今日登录人数
        int todayNumRes = getTodayLogSerive.getTodayLog();
        //获取一共登录的人数
        int allNumRes = getAllLogService.getAllLogService();
        res.put(todayNum,todayNumRes);
        res.put(allNum,allNumRes);


        return ApiResult.success(200,"success",res);
    }



}
