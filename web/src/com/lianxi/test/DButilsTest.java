package com.lianxi.test;


import com.com.Myexception;
import com.utils.ConnectionManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Assert;
import org.junit.Test;

import com.entity.Card;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * Created by acer on 2017/3/14.
 */
public class DButilsTest {
    @Test
    public void datasave() {
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        String sql = "insert intos card(cardnumber,name,tel) values(?,?,?)";

        try {
            queryRunner.update( sql, "A179", "李晓明", "987");
        } catch (SQLException e) {
           throw new Myexception("sql异常！",e);
        }

    }

    @Test
    public void datamodif() {
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        String sql = "update card set cardnumber=? , tel=? where name=?";

        try {
            queryRunner.update( sql, "A963", "183006", "李晓明");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void dataDelete() {
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());
        String sql = "delete from card where name=?";

        try {
            queryRunner.update( sql, "李晓明");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void queryOne() {
        String sql = "select * from card where name=?";
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());

        try {
            Card card = queryRunner.query( sql, new BeanHandler<Card>(Card.class), "曹操");
            System.out.println(card);
            Assert.assertNotNull(card);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void queryAll() {
        String sql = "select * from card ";
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());

        try {
            List<Card> cardList = queryRunner.query( sql, new BeanListHandler<>(Card.class));
            System.out.println(cardList);
            Assert.assertEquals(cardList.size(), 4);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void queryOnemap() {
        String sql = "select * from card where name=? ";
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());

        try {
            Map<String, Object> map = queryRunner.query( sql, new MapHandler(), "曹操");
            for (Map.Entry entry : map.entrySet()
                    ) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
                Assert.assertNotNull(map);
            }


            System.out.println(map);
            Assert.assertNotNull(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void queryAllmap() {
        String sql = "select * from card  ";
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());

        try {
            List<Map<String, Object>> mapList = queryRunner.query( sql, new MapListHandler());
            for (Map<String, Object> map : mapList
                    ) {
                for (Map.Entry entry : map.entrySet()
                        ) {
                    System.out.println(entry.getKey() + "=" + entry.getValue());
                    Assert.assertEquals(mapList.size(),4);
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void queryCount(){
        String sql = "select count(*) from card ";
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());

        try {
            Long aLong = queryRunner.query( sql, new ScalarHandler<Long>());
            Assert.assertEquals(new Long(5) ,aLong);
            System.out.println(aLong);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void queryCloum(){
        String sql = "select name from card ";
        QueryRunner queryRunner = new QueryRunner(ConnectionManager.getDataSource());

        try {
            List<String> list= queryRunner.query( sql, new ColumnListHandler<String>());
            Assert.assertEquals(list.size() ,5);
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
