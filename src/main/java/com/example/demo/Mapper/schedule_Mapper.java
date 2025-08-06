package com.example.demo.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface schedule_Mapper{
    @Insert("insert into aa(name) values (#{b})")
    int insert1(String b);

    @Insert("insert into aa values (#{b},#{a})")
    int insert2(String b);
}
