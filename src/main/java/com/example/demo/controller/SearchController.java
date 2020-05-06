package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.getProductByTypeService;
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
public class SearchController {

    public static final String userName = "nickName";
    public static final String productList = "productList";

    @Autowired
    private getProductByTypeService getProductByType;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ApiResult search(@RequestParam(required = false) String nickName , @RequestParam("type") String type){
        HashMap res = new HashMap();
        //参数校验
        if (getParams(type) == false){
            logger.warn("search接口type字段异常");
            return ApiResult.success(20001,"参入参数异常","");
        }
        //通过类别拿product
        ArrayList<Product> productRes = new ArrayList<Product>();
        productRes = getProductByType.getProductByType(type);
        if (productRes == null){
            logger.warn("search接口获取getProductByType返回为空");
            return ApiResult.success(20001,"获取数据为空","");
        }
        //todo 根据产品名搜索



        res.put(userName,nickName);
        res.put(productList,productRes);


        return ApiResult.success(200,"success",res);
    }

    public boolean getParams(String type){
        if (type == null || type.length() > 30){
            return false;
        }

        return true;
    }

}
