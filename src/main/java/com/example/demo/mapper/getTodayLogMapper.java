package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface getTodayLogMapper {
    @Select("select count(*) from dolog_tbl where visit_time=#{visit_time}")
    int getTodayLog(@Param("visit_time") String visit_time);
}
