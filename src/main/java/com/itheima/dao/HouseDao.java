package com.itheima.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseDao {

    @Insert("insert into house (username, buildname) values(#{username},#{buildname})")
    public int createHouse(String username, String buildname);
}
