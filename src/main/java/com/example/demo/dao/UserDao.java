package com.example.demo.dao;


import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    /**
     * 根据名字查询用户信息
     * @param name
     * @return
     */
    @Select("select * from user  where name = #{name}")
    public User findByUserName(@Param("name") String name);

}
