package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select username from tb_user where username like #{username} and password like #{password}")
    public String login(String username, String password);

    @Insert("insert into tb_user(username, password, PhoneNumber) values(#{username}, #{password}, #{PhoneNumber})")
    public int register(String username, String password, String PhoneNumber);

    @Select("select username,PhoneNumber from tb_user where username like #{username} ")
    public  User show(String username);
}
