package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface addProductMapper {
    @Insert("insert into product_tbl(product_sell_user, product_name, product_type, product_describe, product_price, product_status,product_release_time,product_image_url) values(#{product_sell_user},#{product_name},#{product_type},#{product_describe},#{product_price},'1',#{product_release_time},#{product_image_url})")
    int addProduct(@Param("product_sell_user") String product_sell_user, @Param("product_name") String product_name, @Param("product_type") String product_type, @Param("product_describe") String product_describe, @Param("product_price") int product_price, @Param("product_release_time") Date product_release_time, @Param("product_image_url") String product_image_url);
}
