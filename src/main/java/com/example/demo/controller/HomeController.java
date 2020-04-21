package com.example.demo.controller;

import com.example.demo.model.Advertising;
import com.example.demo.model.Product;
import com.example.demo.model.Product_Visit;
import com.example.demo.service.getAdvertisingService;
import com.example.demo.service.getNewProductService;
import com.example.demo.service.getProductByProductIdService;
import com.example.demo.service.getVisitMostService;
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
public class HomeController {

    public static final int hotcount = 5;
    public static final int newNum = 25;
    public static final String adv = "adv";
    public static final String product = "product";
    public static final String userName = "nickName";
    @Autowired
    private getAdvertisingService getAdvertising;

    @Autowired
    private getVisitMostService getVisitMost;

    @Autowired
    private getProductByProductIdService getProductByProductId;

    @Autowired
    private getNewProductService getNewProduct;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ApiResult home(@RequestParam("nickName") String nickName){


        HashMap res = new HashMap();
        res.put(userName,nickName);
        //todo
        //获取轮播图  轮播图从广告表里面拉最多只能拉三张
        if (getParams(nickName) == false){
            logger.warn("/home nickName超长");
            return ApiResult.success(20001,"nickname 超长了","");
        }

        ArrayList<Advertising> advRes = getAdvertising.getAdvertising();
        if (advRes == null){
            logger.warn("home接口getAdvertising方法返回数据为空");
            return ApiResult.success(20001,"广告数据获取异常","");
        }

        res.put(adv,advRes);

        //获取推荐的List
        ArrayList<Product> productRes = new ArrayList<Product>();
        //获取3条自己观看最多种类的类别的数据

        //策略为拉5条打点次数最高的商品 再加25条数据
        ArrayList<Product_Visit> topVisits = new ArrayList<Product_Visit>();
        topVisits = getVisitMost.getVisitMost(hotcount);
        if (topVisits == null){
            logger.warn("home接口getVisitMost方法返回为空");
            //不需要返回错误,因为可能没有查看记录
        }
        //拿到数据之后 循环查找对应的商品表信息
        if (topVisits != null){
            for (Product_Visit topVisit:topVisits) {
                int product_id = topVisit.getProduct_id();
                Product product = getProductByProductId.getProductByProductId(product_id);
                if (product == null){
                    logger.warn("home接口getProductByProductId返回为空");
                    return ApiResult.success(20001,"获取热门数据错误","");
                }
                productRes.add(product);
            }
        }

        //获取最新的25条数据
        ArrayList<Product> newProducts = getNewProduct.getNewProduct(newNum);
        if (newProducts == null){
            logger.warn("getNewProduct方法返回为空");
            return ApiResult.success(20001,"获取最新数据错误","");
        }

        //把25条数据放入队列
        for (Product product:newProducts){
            productRes.add(product);
        }

        //过滤出重复的商品
        for (int i = 0;i < productRes.size();i++){
            for (int j = 0;j < productRes.size();j++){
                if (productRes.get(i) == productRes.get(j) && i != j){
                    productRes.remove(i);
                }
            }
        }

        //放入结果集中
        res.put(product,productRes);


        return ApiResult.success(200,"success",res);
    }

    public boolean getParams(String nickName){
        if (nickName == null || nickName.length() > 30){
            return false;
        }

        return true;
    }
}
