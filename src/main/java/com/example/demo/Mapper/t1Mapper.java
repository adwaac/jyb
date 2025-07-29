package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface t1Mapper extends BaseMapper<User> {
    @Select("select userid from user where username = #{username} and md = #{md}")
    int log(String username, String md);
}
