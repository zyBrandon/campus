package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.service.addAddressService;
import com.example.demo.service.getAddressService;
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
public class GetAddressController {

    public static final String addressRes = "addressRes";

    @Autowired
    private getAddressService getAddressService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getaddress",method = RequestMethod.GET)
    public ApiResult getaddress(@RequestParam("nickName") String nickName){
        HashMap res = new HashMap();

        if (getParams(nickName) == false){
            logger.warn("getaddress参数错误");
            return ApiResult.success(20001,"参数错误","");
        }

        ArrayList<Address> addRes = getAddressService.getAddress(nickName);
        if (addRes == null){
            logger.warn("getaddress获取数据为空");
        }

        res.put(addressRes,addRes);

        return ApiResult.success(200,"success",res);
    }

    public boolean getParams(String nickName){
        if (nickName == null){
            return false;
        }

        return true;
    }
}
