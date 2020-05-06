package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface getAllLogMapper {
    @Select("select count(*) from dolog_tbl")
    int getAllLog();
}
