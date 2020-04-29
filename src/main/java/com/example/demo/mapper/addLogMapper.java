package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface addLogMapper {
    @Insert("insert into dolog_tbl(nickName,visit_time) values(#{nickName},#{visit_time})")
    int addLog(@Param("nickName") String nickName, @Param("visit_time") Date visit_time);
}
