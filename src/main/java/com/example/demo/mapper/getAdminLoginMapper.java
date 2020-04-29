package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface getAdminLoginMapper {
    @Select("select count(*) from admin_tbl where admin_name=#{admin_name} and admin_pass=#{admin_pass}")
    int getAdminLogin(@Param("admin_name") String admin_name,@Param("admin_pass") String admin_pass);
}
