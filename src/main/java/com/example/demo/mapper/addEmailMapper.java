package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface addEmailMapper {
    @Insert("insert into admin_email_tbl(email_num,email_title,email_content,email_time) values(#{email_num},#{email_title},#{email_content},#{email_time})")
    int addEmail(@Param("email_num") String email_num,@Param("email_title") String email_title,@Param("email_content") String email_content,@Param("email_time") Date email_time);
}
