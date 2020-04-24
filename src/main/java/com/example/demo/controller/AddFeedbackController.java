package com.example.demo.controller;

import com.example.demo.service.addFeedbackService;
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
public class AddFeedbackController {

    public static final String pop = "pop";
    public static final String popContent = "插入数据成功";

    @Autowired
    private addFeedbackService addFeedbackService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/addfeedback" ,method = RequestMethod.GET)
    public ApiResult addfeedback(@RequestParam("feedback_user") String feedback_user,@RequestParam("feedback_title") String feedback_title,@RequestParam("feedback_content") String feedback_content){
        HashMap res = new HashMap();
        if (getParams(feedback_user, feedback_title, feedback_content) == false){
            logger.warn("addfeedback参数错误");
            return ApiResult.success(20001,"参数错误","");
        }

        boolean addRes = addFeedbackService.addFeedback(feedback_user, feedback_title, feedback_content);
        if (addRes == false){
            logger.warn("addfeedback接口添加数据失败");
            return ApiResult.success(20001,"添加反馈失败","");
        }

        res.put(pop,popContent);


        return ApiResult.success(200,"success",res);
    }

    public boolean getParams(String feedback_user,String feedback_title,String feedback_content){
        if (feedback_user == null || feedback_title == null || feedback_content == null){
            return false;
        }

        return true;
    }
}
