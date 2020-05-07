package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface addLikeDBMapper {
    @Insert("insert into like_tbl(nickName,product_id,like_time) values(#{nickName},#{product_id},#{like_time})")
    int addLikeDB(@Param("nickName") String nickName, @Param("product_id") int product_id, @Param("like_time") Date like_time);
}
