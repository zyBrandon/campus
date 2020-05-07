package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface getAdminRightMapper {
    @Select("select right_name from admin_right_tbl where admin_name=#{admin_name}")
    String getAdminRight(@Param("admin_name") String admin_name);
}
