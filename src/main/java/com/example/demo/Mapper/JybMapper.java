package com.example.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface JybMapper {
    @Select("select * from liansuo")
    List<Map<String,Object>> SelectLianSuo();
}
