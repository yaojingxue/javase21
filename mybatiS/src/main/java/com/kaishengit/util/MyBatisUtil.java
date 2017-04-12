package com.kaishengit.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.io.IOException;

/**
 * Created by acer on 2017/4/12.
 */
public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory = builderSqlSessionFactory();

    private static SqlSessionFactory builderSqlSessionFactory() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            return sessionFactory;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession();
    }
}
