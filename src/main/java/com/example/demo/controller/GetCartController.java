package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.Shopping_Cart;
import com.example.demo.service.getCartListService;
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
public class GetCartController {

    public static final String cartList = "cartList";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private getCartListService getCartListService;

    @Autowired
    private getProductByProductIdService getProductByProductIdService;

    @RequestMapping(value = "/getcart",method = RequestMethod.GET)
    public ApiResult getcart(@RequestParam("nickName") String nickName){
        HashMap res = new HashMap();
        if (getParams(nickName) == false){
            logger.warn("/home nickName超长");
            return ApiResult.success(20001,"nickname 超长了","");
        }
        //获取购物车列表product_id
        ArrayList<Shopping_Cart> carts = getCartListService.getCartList(nickName);

        //拿到product_id去获取商品信息
        //商品的信息存入productList
        ArrayList<Product> productList = new ArrayList<Product>();
        if (carts != null){
            for (Shopping_Cart shopping_cart:carts){
                Product product = getProductByProductIdService.getProductByProductId(shopping_cart.getProduct_id());
                productList.add(product);
            }
        }
        res.put(cartList,productList);

        return ApiResult.success(200,"success",res);
    }

    public boolean getParams(String nickName){
        if (nickName == null || nickName.length() > 30){
            return false;
        }

        return true;
    }

}
