package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.getProductBySellNameService;
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
public class GetSellController {

    public static final String productRes = "productRes";

    @Autowired
    private getProductBySellNameService getProductBySellNameService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getsell",method = RequestMethod.GET)
    public ApiResult getsell(@RequestParam("nickName") String nickName){
        HashMap res = new HashMap();

        if (getParams(nickName) == false){
            logger.warn("getsell接口参数错误");
            return ApiResult.success(20001,"参数异常","");
        }
        //获取出售的product中sell_username是本人的,再返回product数据
        ArrayList<Product> sellProduct = getProductBySellNameService.getProductBySellName(nickName);
        if (sellProduct == null){
            logger.warn("getsell商品数据为空");
        }
        res.put(productRes,sellProduct);

        return ApiResult.success(200,"success",res);
    }

    public boolean getParams(String product_sell_user){
        if (product_sell_user == null || product_sell_user.length() > 40){
            return false;
        }

        return true;
    }
}
