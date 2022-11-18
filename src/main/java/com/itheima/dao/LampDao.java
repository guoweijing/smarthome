package com.itheima.dao;

import com.itheima.domain.Lamp;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LampDao {
    @Insert("insert into lamp (name,place,username) values (#{name},#{place},#{username}) ")
    public  int insertlamp(Lamp lamp);

    @Delete("delete from lamp where name like #{name} and username like #{username} ")
    public int deletelamp(String name,String username);

    @Select("select * from lamp where name like #{name} and username like #{username}")
    public Lamp selectlamp(String name,String username);

    @Update("update lamp  set light =#{light} where name like #{name} and username like #{username}")
    public int updatelamp(Lamp lamp);
}
