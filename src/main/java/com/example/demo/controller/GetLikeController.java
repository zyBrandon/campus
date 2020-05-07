package com.example.demo.controller;

import com.example.demo.service.getLikeRedisService;
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
public class GetLikeController {

    public static final String likeNum = "likeNum";

    @Autowired
    private getLikeRedisService getLikeRedisService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getlike",method = RequestMethod.GET)
    public ApiResult getlike(@RequestParam("nickName") String nickName){
        HashMap res = new HashMap();

        String likeRes = getLikeRedisService.getLikeRedis(nickName);
        if (likeRes == null){
            logger.warn("获取点赞数据失败");
            return ApiResult.success(20001,"获取点赞次数失败","");
        }
        res.put(likeNum,likeRes);


        return ApiResult.success(200,"success",res);
    }

}
