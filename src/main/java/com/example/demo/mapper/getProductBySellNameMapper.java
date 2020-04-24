package com.example.demo.mapper;

import com.example.demo.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface getProductBySellNameMapper {
    @Select("select * from product_tbl where product_sell_user=#{product_sell_user}")
    ArrayList<Product> getProductBySellName(@Param("product_sell_user") String product_sell_user);
}
