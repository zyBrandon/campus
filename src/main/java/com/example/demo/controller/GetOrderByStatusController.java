package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.service.getOrderByStatusService;
import com.example.demo.service.getProductByProductIdService;
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
public class GetOrderByStatusController {

    public static final String allOrder = "0";
    public static final String ongongOrder = "1";
    public static final String finishOrder = "2";
    public static final String pop = "pop";
    public static final String popContent = "数据为空";
    public static final String productList = "productList";
    public static final String productContent = "productContent";
    public static final String orderStatus = "order_status";

    @Autowired
    private getOrderByStatusService getOrderByStatusService;

    @Autowired
    private getProductByProductIdService getProductByProductIdService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getorder",method = RequestMethod.GET)
    public ApiResult getorder(@RequestParam("nickName") String nickName,@RequestParam("order_status") String order_status){
        HashMap res = new HashMap();
        //参数校验
        if (getParams(nickName,order_status) == false){
            logger.warn("getorder接口参数错误");
            return ApiResult.success(20001,"参数错误","");
        }

        //结果集为product队列
        ArrayList<Object> productRes = new ArrayList<>();

        //查询order表
        ArrayList<Order> orderList = getOrderByStatusService.getOrderByStatus(nickName, order_status);
        //为空不查询
        if (orderList == null){
            res.put(pop,popContent);
            res.put(productList,productRes);
            logger.warn("该用户订单为空");
            return ApiResult.success(200,"success",res);
        }


        //查询商品信息
        for (Order order:orderList){
            HashMap tempRes = new HashMap();
            int product_id = order.getProduct_id();
            Product product = getProductByProductIdService.getProductByProductId(product_id);
            if (product == null){
                logger.warn("获取商品信息异常");
                return ApiResult.success(20001,"获取商品信息异常","");
            }
            tempRes.put(productContent,product);
            tempRes.put(orderStatus,order.getOrder_status());
            productRes.add(tempRes);
        }

        res.put(productList,productRes);



        return ApiResult.success(200,"success",res);

    }

    public boolean getParams(String nickName,String order_status){
        if (nickName == null || nickName.length() > 30 || order_status == null){
            return false;
        }
        if (!order_status.equals(allOrder) && !order_status.equals(ongongOrder) && !order_status.equals(finishOrder)){
            return false;
        }

        return true;
    }

}
