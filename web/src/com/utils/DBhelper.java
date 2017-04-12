package com.utils;

import com.com.Myexception;
import com.entity.Card;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


/**
 * Created by acer on 2017/3/16.
 */
public class DBhelper {
    private static Logger logger= LoggerFactory.getLogger(DBhelper.class);
    public static void update(String sql,Object...prams){
       QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try {
            queryRunner.update(sql,prams);
            logger.debug("{}正常运行了！",sql);
        } catch (SQLException e) {
            logger.error("{}运行异常",sql);
            throw new Myexception("执行"+sql+"失败！", e);
        }
    }
    public static <T> T query(String sql,ResultSetHandler<T> handler,Object...prams){
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try {
            T result= queryRunner.query( sql, handler,prams);
            logger.debug("{}正常运行了！",sql);
            return result;
        } catch (SQLException e) {
            logger.error("{}运行异常",sql);
            throw new Myexception("执行"+sql+"失败！", e);
        }
    }
}
