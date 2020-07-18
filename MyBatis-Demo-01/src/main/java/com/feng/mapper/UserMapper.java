package com.feng.mapper;

import com.feng.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;

import java.util.List;
import java.util.Map;
@Alias("user")
public interface UserMapper {

    List<User> getUserList();
    //获取
    User getUserListById(int id);

    List<User>  getUserListByMap(Map<String, Object> map);

    List<User> getUserListByNP(@Param("name") String name, @Param("pwd") String pwd);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
