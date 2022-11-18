package com.itheima.dao;

import com.itheima.domain.Furniture;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HomeDao {

    @Select("select * from allhome where place like #{place} and username like #{username}")
    public List<Furniture> selectbyplace(String place, String username);

    @Delete("delete from allhome where name like #{name} and username like #{username}")
    public int deletebyname(String name,String username);

    @Insert("insert into allhome (name, kind, place, username) values(#{name},#{kind},#{place},#{username})  ")
    public int insertone(Furniture furniture);

    @Select("select * from allhome where username like #{username}")
    public List<Furniture> selectall( String username);

    @Update("update allhome set status = #{status} where username like #{username} and name like #{name}")
    public int update(Furniture furniture);
}
