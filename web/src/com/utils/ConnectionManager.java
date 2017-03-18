package com.utils;

import com.com.Myexception;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by acer on 2017/3/14.
 */
public class ConnectionManager {
    private static BasicDataSource dataSource = new BasicDataSource();
    public static DataSource getDataSource(){
        return dataSource;
    }

    static {
        Properties properties = new Properties();
        try {
            properties.load(ConnectionManager.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new Myexception("读取连接失败！", e);
        }
            dataSource.setDriverClassName(properties.getProperty("jdbc.driver"));
            dataSource.setUrl(properties.getProperty("jdbc.url"));
            dataSource.setUsername(properties.getProperty("jdbc.username"));
            dataSource.setPassword(properties.getProperty("jdbc.password"));
            dataSource.setInitialSize(Integer.parseInt(properties.getProperty("jdbc.initialsize")));
            dataSource.setMaxTotal(Integer.parseInt(properties.getProperty("jdbc.maxtotal")));
            dataSource.setMinIdle(Integer.parseInt(properties.getProperty("jdbc.minidle")));
            dataSource.setMaxWaitMillis(Integer.parseInt(properties.getProperty("jdbc.maxwaitmillis")));
            dataSource.setMaxIdle(Integer.parseInt(properties.getProperty("jdbc.maxidle")));

    }

//    public static Connection getConnection() throws Myexception {
//        try {
//            Connection connection = dataSource.getConnection();
//            return connection;
//        } catch (SQLException e) {
//            throw new Myexception("获取数据库连接失败！", e);
//        }
//
//    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new Myexception("关闭数据库连接失败！", e);
        }
    }
}
