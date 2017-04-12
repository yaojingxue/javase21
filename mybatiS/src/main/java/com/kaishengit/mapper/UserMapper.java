package com.kaishengit.mapper;

import com.kaishengit.pojo.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2017/4/12.
 */
public interface UserMapper {
    User findParams(Map<String,Object> map);
    User findParam(@Param("name") String name, @Param("pwd")String pwd);
    User findMap(Map<String ,Object> pram);
    User findById(Integer id);
    void addUser(User user);
    void removeName(String name);
    void updateUser(User user);
    List<User> findAll();
}
