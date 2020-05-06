package com.example.demo.controller;

import com.example.demo.model.Feedback;
import com.example.demo.service.getFeedbackService;
import com.example.demo.service.getLoginRedisService;
import com.example.demo.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class GetFeedbackController {

    public static final String feedback = "feedback";

    @Autowired
    private getLoginRedisService getLoginRedisService;

    @Autowired
    private getFeedbackService getFeedbackService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getfeedback",method = RequestMethod.GET)
    public ApiResult getfeedback(@RequestParam("nickName") String nickName){
        HashMap res = new HashMap();

        //判断是否登录用户
        boolean onlineRes = getLoginRedisService.getUserLand(nickName);
        if (onlineRes == false){
            logger.warn("该用户未登录");
            return ApiResult.success(20003,"用户未登录","");
        }

        ArrayList<Feedback> feedbackList = getFeedbackService.getFeedback();

        res.put(feedback,feedbackList);

        return ApiResult.success(200,"success",res);
    }

}
