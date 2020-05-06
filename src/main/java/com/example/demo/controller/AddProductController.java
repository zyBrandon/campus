package com.example.demo.controller;

import com.example.demo.service.addAddressService;
import com.example.demo.service.addPointService;
import com.example.demo.service.addProductService;
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
public class AddProductController {

    public static final String pop = "pop";
    public static final String popContent = "发布物品成功";

    @Autowired
    private addProductService addProductService;

    @Autowired
    private addAddressService addAddressService;

    @Autowired
    private addPointService addPointService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/addproduct",method = RequestMethod.GET)
    public ApiResult addproduct(@RequestParam("product_sell_user") String product_sell_user,@RequestParam("product_name") String product_name,@RequestParam("product_type") String product_type,
                                @RequestParam("product_describe") String product_describe,@RequestParam("product_price") int product_price,@RequestParam("product_image_url") String product_image_url,
                                @RequestParam("address") String address,@RequestParam("name") String name,
                                @RequestParam("latitude") String latitude,@RequestParam("longitude") String longitude){

        HashMap res = new HashMap();

        if (getParams(product_sell_user, product_name, product_type, product_describe, product_price,product_image_url) == false){
            logger.warn("addproduct接口参数错误");
            return ApiResult.success(20001,"参数错误","");
        }

        //商品入库
        boolean addRes = addProductService.addProduct(product_sell_user,product_name,product_type,product_describe,product_price,product_image_url);
        if (addRes == false){
            logger.warn("addproduct商品添加数据库失败");
            return ApiResult.success(20001,"添加数据失败","");
        }
        //添加地址
        boolean addAddressRes = addAddressService.addAddress(address,product_sell_user,name,longitude,latitude);
        if (addAddressRes == false){
            logger.warn("addAddress方法添加数据失败");
            return ApiResult.success(20001,"添加数据失败","");
        }

        //增加用户积分
        boolean addPointRes = addPointService.addPoint(product_sell_user);
        if (addPointRes == false){
            logger.warn("添加积分失败");
            return ApiResult.success(20001,"添加积分失败","");
        }

        res.put(pop,popContent);
        return ApiResult.success(200,"success",res);

    }

    public boolean getParams(String product_sell_user,String product_name,String product_type,String product_describe,int product_price,String product_image_url){
        if (product_sell_user == null || product_name == null || product_type ==null || product_describe == null || product_price < 0 || product_image_url == null){
            return false;
        }

        return true;
    }
}
