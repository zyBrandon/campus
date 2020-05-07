package com.example.demo.controller;

import com.example.demo.service.addLoginRedisService;
import com.example.demo.service.getAdminLoginService;
import com.example.demo.service.getAdminRightService;
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
public class AdminLoginController {

    public static final String pop = "pop";
    public static final String popLogin = "登录成功";
    public static final String popLoginFail = "登录失败";
    public static final String primary = "primary";
    public static final String senior = "senior";
    public static final String Right = "right";

    @Autowired
    private getAdminLoginService getAdminLoginService;

    @Autowired
    private addLoginRedisService addLoginRedisService;

    @Autowired
    private getAdminRightService getAdminRightService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/adminlogin",method = RequestMethod.GET)
    public ApiResult adminlogin(@RequestParam("admin_name") String admin_name,@RequestParam("admin_pass") String admin_pass){
        HashMap res = new HashMap();
        if (getParams(admin_name,admin_pass) == false){
            logger.warn("adminlog参数错误");
            return ApiResult.success(20001,"参数错误","");
        }

        //查询账号密码

        boolean resLogin = getAdminLoginService.getAdminLogin(admin_name, admin_pass);
        if (resLogin == false){
            res.put(pop,popLoginFail);
            return ApiResult.success(20002,"密码错误",res);
        }

        //加入redis中
        boolean addRedisRes = addLoginRedisService.addLoginRedis(admin_name);
        if (addRedisRes == false){
            logger.warn("添加redis失败");
            return ApiResult.success(20001,"添加redis失败","");
        }

        //todo 获取管理员权限
        String adminRight = getAdminRightService.getAdminRight(admin_name);
        if (adminRight == null){
            logger.warn("获取权限失败");
            return ApiResult.success(20001,"获取权限失败","");
        }
        if (adminRight.equals(primary)){
            res.put(Right,primary);
        }
        if (adminRight.equals(senior)){
            res.put(Right,senior);
        }

        res.put(pop,popLogin);


        return ApiResult.success(200,"success",res);
    }

    public boolean getParams(String admin_name,String admin_pass){
        if (admin_name == null || admin_pass == null || admin_name.length() > 20 || admin_pass.length() > 20){
            return false;
        }

        return true;
    }
}
