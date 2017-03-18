package com.utils;

import com.com.Myexception;
import com.entity.Card;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Created by acer on 2017/3/16.
 */
public class DBhelper {
    public static void update(String sql,Object...prams){
       QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try {
            queryRunner.update(sql,prams);
        } catch (SQLException e) {
            throw new Myexception("执行"+sql+"失败！", e);
        }
    }
    public static <T> T query(String sql,ResultSetHandler<T> handler,Object...prams){
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        try {
             return queryRunner.query( sql, handler,prams);
        } catch (SQLException e) {
            throw new Myexception("执行"+sql+"失败！", e);
        }
    }
}
