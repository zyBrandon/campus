package com.example.demo.mapper;

import com.example.demo.model.Shopping_Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface getCartListMapper {
    @Select("select * from shopping_cart_tbl where product_buy_username=#{product_buy_username}")
    ArrayList<Shopping_Cart> getCartList(@Param("product_buy_username") String product_buy_username);
}
