package com.example.demo.service;

import com.example.demo.mapper.getCartListMapper;
import com.example.demo.model.Shopping_Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class getCartListService {

    @Autowired
    private getCartListMapper getCartListMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ArrayList<Shopping_Cart> getCartList(String nickName){
        if (getParams(nickName) == false){
            logger.warn("getCartList方法参数异常");
            return null;
        }

        ArrayList<Shopping_Cart> cartList = getCartListMapper.getCartList(nickName);
        if (cartList == null){
            logger.warn("getCartList方法查询购物车内容为为空");
            return null;
        }

        return cartList;

    }

    public boolean getParams(String nickName){
        if (nickName == null || nickName.length() > 30){
            return false;
        }

        return true;
    }
}
