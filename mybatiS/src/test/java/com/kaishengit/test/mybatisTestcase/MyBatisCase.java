package com.kaishengit.test.mybatisTestcase;


import com.kaishengit.pojo.User;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.io.Reader;
import java.util.List;


/**
 * Created by acer on 2017/4/11.
 */
public class MyBatisCase {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(MyBatisCase.class);

    @Test
    public void testfindById() {
        SqlSession session = MyBatisUtil.getSqlSession();
        User user = session.selectOne("com.kaishengit.mapper.UserMapper.findById", 2);
        logger.debug("{}", user);
        //Assert.assertNotNull(user);
        session.close();


    }

    @Test
    public void testRemove() {
        SqlSession session = MyBatisUtil.getSqlSession();
        int i = session.delete("com.kaishengit.mapper.UserMapper.removeName", "lili");
        logger.debug("{}", i);
        session.commit();
        session.close();


    }

    @Test
    public void testAddUser() {
        SqlSession session = MyBatisUtil.getSqlSession();
        User user = new User();
        user.setName("杭州");
        user.setPwd("yaoi");
        session.insert("com.kaishengit.mapper.UserMapper.addUser", user);
        session.commit();
        logger.debug("{}", user);
        session.close();


    }

    @Test
    public void updateUser() {
        SqlSession session = MyBatisUtil.getSqlSession();
        int id = 1;
        User user = session.selectOne("com.kaishengit.mapper.UserMapper.findById", id);
        user.setName("修改");
        user.setPwd("768");
        session.update("com.kaishengit.mapper.UserMapper.updateUser", user);
        logger.debug("{}", user);
        session.commit();
        session.close();

    }

    @Test
    public void testfindAll() {
        SqlSession session = MyBatisUtil.getSqlSession();
        List<User> list = session.selectList("com.kaishengit.mapper.UserMapper.findAll");
        for (User user : list
                ) {
            logger.debug("{}", user);
        }

    }
}
