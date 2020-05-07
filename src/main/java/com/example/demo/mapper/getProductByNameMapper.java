package com.example.demo.mapper;

import com.example.demo.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface getProductByNameMapper {
    @Select("select * from product_tbl where product_name=#{product_name}")
    ArrayList<Product> getProductByName(@Param("product_name") String product_name);
}
