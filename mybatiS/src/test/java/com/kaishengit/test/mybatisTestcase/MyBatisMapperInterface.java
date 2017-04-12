package com.kaishengit.test.mybatisTestcase;

import com.google.common.collect.Maps;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.User;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


/**
 * Created by acer on 2017/4/12.
 */
public class MyBatisMapperInterface {
    private Logger logger= LoggerFactory.getLogger(MyBatisMapperInterface.class);
    @Test
    public void testfindParams(){
        SqlSession session= MyBatisUtil.getSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        Map<String ,Object> map=Maps.newHashMap();
        map.put("id",8);
        map.put("name","jim");
        map.put("pwd","234");
        User user=userMapper.findParams(map);
        logger.debug("{}",user);
        session.close();
        //map.put("id",2);
    }
    @Test
    public void testfindParam(){
        SqlSession session= MyBatisUtil.getSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user= userMapper.findParam("修改","768");
        logger.debug("{}",user);
    }
    @Test
    public void testfindMap(){
        SqlSession session= MyBatisUtil.getSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        Map<String,Object> param= Maps.newHashMap();
        param.put("name","修改");
        param.put("pwd","768");
       User user= userMapper.findMap(param);
        logger.debug("{}",user);
    }
    @Test
    public void testfindById(){
        SqlSession session= MyBatisUtil.getSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=userMapper.findById(2);
        logger.debug("{}",user);
        session.close();
    }
    @Test
    public void testfindAll(){
        SqlSession session=MyBatisUtil.getSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> list=userMapper.findAll();
        for (User user:list
             ) {
            logger.debug("{}",user);
        }
    }
    @Test
    public void testaddUser(){
        SqlSession session=MyBatisUtil.getSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=new User();
        user.setName("姚明");
        user.setPwd("987000");
        userMapper.addUser(user);
        int id=user.getId();
        logger.debug("{}",id);
        session.commit();
        session.close();
    }
    @Test
    public void testupdateUser(){
        SqlSession session=MyBatisUtil.getSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        int id=25;
        User user=userMapper.findById(25);
        user.setName("chppp");
        user.setPwd("98776");
        userMapper.updateUser(user);
        session.commit();
        session.close();
    }
    @Test
    public void testremoveName(){
        SqlSession session=MyBatisUtil.getSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        userMapper.removeName("chooo");
        session.commit();
        session.close();
    }
}
