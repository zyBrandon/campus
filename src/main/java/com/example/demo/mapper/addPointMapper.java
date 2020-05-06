package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface addPointMapper {
    @Insert("insert into point_tbl(nickName,point_time) values(#{nickName},#{point_time})")
    int addPoint(@Param("nickName") String nickName, @Param("point_time") Date point_time);
}
