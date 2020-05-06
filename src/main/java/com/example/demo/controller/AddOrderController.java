package com.example.demo.controller;

import com.example.demo.service.addOrderService;
import com.example.demo.service.updateProductStatusByProductIdService;
import com.example.demo.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

@RestController
public class AddOrderController {

    public static final String pop = "pop";
    public static final String popContent = "添加订单成功";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private addOrderService addOrderService;

    @Autowired
    private updateProductStatusByProductIdService updateProductStatusByProductIdService;

    @RequestMapping(value = "/addorder",method = RequestMethod.GET)
    public ApiResult addorder(@RequestParam("product_buy_username") String product_buy_username,@RequestParam("product_id") int product_id){
        HashMap res = new HashMap();

        if (getParams(product_buy_username, product_id) == false){
            logger.warn("addorder接口参数错误");
            return ApiResult.success(20001,"参数错误","");
        }

        Date date = new Date();

        boolean addOrderRes = addOrderService.addOrder(product_buy_username,product_id,date);
        if (addOrderRes == false){
            logger.warn("addOrder接口添加数据失败");
            return ApiResult.success(20001,"添加订单失败","");
        }

        //todo商品的字段改变product_status
        boolean updateRes = updateProductStatusByProductIdService.updateProductStatusByProductId(product_id);
        if (updateRes == false){
            logger.warn("addorder更改状态值异常");
            return ApiResult.success(20001,"更改状态值异常","");
        }

        //todo 购买自己的商品

        res.put(pop,popContent);

        return ApiResult.success(200,"success",res);

    }

    public boolean getParams(String product_buy_username,int product_id){
        if (product_buy_username.length() > 30 || product_buy_username == null || product_id < 0){
            return false;
        }

        return true;
    }
}
