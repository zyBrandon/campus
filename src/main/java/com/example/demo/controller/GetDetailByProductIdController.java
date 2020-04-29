package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.addVisitService;
import com.example.demo.service.getProductByProductIdService;
import com.example.demo.util.ApiResult;
import com.example.demo.util.StringToInt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class GetDetailByProductIdController {

    public static final String productDetail = "product";

    @Autowired
    private getProductByProductIdService getProductByProductId;

    @Autowired
    private addVisitService addVisitService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getdetail",method = RequestMethod.GET)
    public ApiResult getdetail(@RequestParam(required = false) String nickName,@RequestParam("product_id") int product_id){

        HashMap res = new HashMap();

        //id转int
        //int product_id = Integer.parseInt(product_id_string);
        if (getParams(product_id) == false){
            logger.warn("getdetail接口参数错误");
            return ApiResult.success(20001,"getdetail接口参数错误","");
        }
        Product product = getProductByProductId.getProductByProductId(product_id);
        if (product == null){
            logger.warn("getdetail接口获取商品信息失败");
            return ApiResult.success(20001,"获取商品详情失败","");
        }

        res.put(productDetail,product);

        //添加个人查看记录信息，为打点用
        boolean addVisit = addVisitService.addVisitService(product_id,nickName);
        if (addVisit == false){
            logger.warn("getdetail添加打点失败");
            return ApiResult.success(20001,"添加推荐打点失败","");
        }

        return ApiResult.success(200,"success",res);

    }

    public boolean getParams(int product_id){
        if (product_id < 0){
            return false;
        }
        return true;
    }

}
