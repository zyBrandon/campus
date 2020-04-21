package com.example.demo.controller;

import com.example.demo.service.addCartService;
import com.example.demo.service.getHaveCartByProductIdAndUsernameService;
import com.example.demo.util.ApiResult;
import org.apache.ibatis.annotations.Param;
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
public class AddCartController {


    public static final String pop = "pop";
    public static final String popContent = "插入数据成功";
    public static final int initCartNum = 0;

    @Autowired
    private getHaveCartByProductIdAndUsernameService getHaveCartByProductIdAndUsername;

    @Autowired
    private addCartService addCart;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/addcart",method = RequestMethod.GET)
    public ApiResult addCart(@RequestParam("product_buy_username") String product_buy_username,@RequestParam("product_id") int product_id){
        HashMap res = new HashMap();
        if (getParams(product_buy_username,product_id) == false){
            logger.warn("addCart接口参数错误");
            return ApiResult.success(20001,"参数错误","");
        }
        //查询是否添加过该购物车
        int cartRes = initCartNum;
        cartRes = getHaveCartByProductIdAndUsername.getHaveCartByProductIdAndUsername(product_buy_username, product_id);
        //todo查看是否购买的自己的商品
        //再加入购物车
        if (cartRes == 0){
            Date date = new Date();
            boolean addCartRes = addCart.addCart(product_id,product_buy_username,date);
            if (addCartRes == false){
                logger.warn("addcart插入数据失败");
                return ApiResult.success(20001,"插入数据失败","");
            }
        }

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
