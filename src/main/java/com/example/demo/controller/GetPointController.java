package com.example.demo.controller;

import com.example.demo.model.Point;
import com.example.demo.service.getLoginRedisService;
import com.example.demo.service.getPointUserService;
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
public class GetPointController {

    public static final String wechat = "wechat";
    public static final String web = "web";
    public static final String list = "list";
    public static final int onePoint = 3;
    public static final String pointRes = "pointRes";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private com.example.demo.service.getLoginRedisService getLoginRedisService;

    @Autowired
    private getPointUserService getPointUserService;

    @RequestMapping(value = "/getpoint",method = RequestMethod.GET)
    public ApiResult getpoint(@RequestParam(required = false) String admin_name,@RequestParam("from_keyword") String from_keyword,@RequestParam(required = false) String nickName){
        HashMap res = new HashMap();


        //判断来源
        //来自微信小程序，则查看自己的学分
        if (from_keyword.equals(wechat)){
            //查看用户的积分
            //获取Point用户的列表
            ArrayList<Point> nickNameList = getPointUserService.getPointUser();
            if (nickNameList == null){
                logger.warn("数据为空");
                return ApiResult.success(20001,"获取数据失败","");
            }
            //拿到所有的积分之后统计改用户的积分
            int countRes = 0;
            for (Point list:nickNameList) {
                if (list.getNickName().equals(nickName)){
                    countRes += onePoint;
                }
            }

            res.put(pointRes,countRes);
        }

        //如果来自网页
        if (from_keyword.equals(web)){

            //判断是否登录用户
            boolean onlineRes = getLoginRedisService.getUserLand(admin_name);
            if (onlineRes == false){
                logger.warn("该用户未登录");
                return ApiResult.success(20003,"用户未登录","");
            }

            //获取Point用户的列表
            ArrayList<Point> nickNameList = getPointUserService.getPointUser();
            if (nickNameList == null){
                logger.warn("数据为空");
                return ApiResult.success(20001,"获取数据失败","");
            }
            res.put(from_keyword,web);

            res.put(list,nickNameList);



        }




        return ApiResult.success(200,"success",res);
    }

}
