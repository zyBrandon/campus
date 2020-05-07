package com.example.demo.controller;

import com.example.demo.service.addLikeDBService;
import com.example.demo.service.addLikeRedisService;
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
public class AddLikeController {

    public static final String addRedis = "addRedis";
    public static final String addDB = "addDB";
    public static final String success = "success";

    @Autowired
    private addLikeDBService addLikeDBService;

    @Autowired
    private addLikeRedisService addLikeRedisService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "addlike",method = RequestMethod.GET)
    public ApiResult addlike(@RequestParam("nickName") String nickName,@RequestParam("product_id") int product_id){
        HashMap res = new HashMap();

        //添加一个key value key为nickName加时间 value

        //nickname的次数加1
        boolean addRedis = addLikeRedisService.addLikeRedis(nickName,product_id);
        if (addRedis == false){
            //兜底直接加入数据库
            boolean addDB = addLikeDBService.addLikeDBService(nickName, product_id);
            if (addDB == false){
                logger.warn("入库失败");
                return ApiResult.success(20001,"入库失败","");
            }
            res.put(addDB,success);
        }

        res.put(addRedis,success);

        return ApiResult.success(200,"success",res);
    }

}
