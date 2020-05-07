package com.example.demo.controller;

import com.example.demo.service.addOrderService;
import com.example.demo.service.deleteCartService;
import com.example.demo.service.updateProductStatusByProductIdService;
import com.example.demo.util.ApiResult;
import com.example.demo.util.RedisUtil;
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
    public static final String cart = "cart";
    public static final String lock = "lock";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private addOrderService addOrderService;

    @Autowired
    private updateProductStatusByProductIdService updateProductStatusByProductIdService;

    @Autowired
    private deleteCartService deleteCartService;

    @Autowired
    private RedisUtil redisUtil;

    private final static long time = 259200;//3天



    @RequestMapping(value = "/addorder",method = RequestMethod.GET)
    public ApiResult addorder(@RequestParam("product_buy_username") String product_buy_username,@RequestParam("product_id") int product_id,@RequestParam(required = false) String from){
        HashMap res = new HashMap();

        if (getParams(product_buy_username, product_id) == false){
            logger.warn("addorder接口参数错误");
            return ApiResult.success(20001,"参数错误","");
        }

        Date date = new Date();

        if ((int)redisUtil.get(lock) == 0){
            //加锁
            redisUtil.set(lock,1,time);
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
            //解锁
            redisUtil.set(lock,0);
        }



        //如果来自购物车，则删除购物车物品
        if (from.equals(cart)){
            boolean deleteCartRes = deleteCartService.deleteCart(product_id, product_buy_username);
            if (deleteCartRes == false){
                logger.warn("删除购物车数据失败");
                return ApiResult.success(20001,"删除购物车数据失败","");
            }
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
