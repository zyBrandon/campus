package com.example.demo.mapper;

import com.example.demo.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface getNewProductMapper {
    @Select("select * from product_tbl where product_status='1' order by product_release_time desc limit #{newNum}")
    ArrayList<Product> getNewProduct(@Param("newNum") int newNum);
}
