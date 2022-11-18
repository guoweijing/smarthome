package com.itheima.dao;

import com.itheima.domain.Lamp;
import com.itheima.domain.Sensor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SensorDao {
    @Insert("insert into sensor (name,place,username) values (#{name},#{place},#{username}) ")
    public  int insertsensor(Sensor sensor);

    @Delete("delete from sensor where name like #{name} and username like #{username} ")
    public int deletesensor(String name,String username);

    @Select("select * from sensor where name like #{name} and username like #{username}")
    public Sensor selectsensor(String name, String username);
}
