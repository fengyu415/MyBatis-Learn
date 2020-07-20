package com.feng.mapper;

import com.feng.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserListByMap();


    List<User> getUserListByPage(Map<String, Integer> map);

     @Select("select * from user where id=#{id}")
     User getUserListByAnnotation(@Param("id") int  id);
    @Insert("insert into user (id,name,pwd) values(#{id},#{name},#{pwd})")
    User  addUserByAnnotation(User user);
    @Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
    User  updateUserByAnnotation(User user);
    @Delete(" delete from user where id=#{id}")
    User  deleteUserByAnnotation(@Param("id") int id);
}
