package com.itheima.dao;

import com.itheima.domain.Door;
import com.itheima.domain.Lamp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DoorDao {
    @Insert("insert into door (name,place,username) values (#{name},#{place},#{username}) ")
    public  int insertdoor(Door door);

    @Delete("delete from door where name like #{name} and username like #{username} ")
    public int deletedoor(String name,String username);

    @Select("select * from door where name like #{name} and username like #{username}")
    public Door selectdoor(String name, String username);
}
