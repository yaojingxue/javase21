package com;


import com.entity.Card;

import com.utils.DBhelper;

import org.apache.commons.dbutils.handlers.*;


import java.util.List;


/**
 * Created by acer on 2017/3/16.
 */
public class CardDAO {
    public void dataCardsave(Card card) {

        String sql = "insert into card(cardnumber,name,tel)values(?,?,?)";
        DBhelper.update(sql, card.getCardnumber(), card.getName(), card.getTel());
    }

    public void dataCarddelete(int id) {

        String sql = "delete from card where id=?";
        DBhelper.update(sql, id);


    }

    public void dataCardupdate(Card card) {

        String sql = "update  card set cardnumber=?,name=?,tel=? where id=?";
        DBhelper.update(sql, card.getCardnumber(), card.getName(), card.getTel(), card.getId());


    }

    public Card QueryCardone(String name) {

        String sql = "select *from card where name=?";
        return DBhelper.query(sql, new BeanHandler<>(Card.class), name);


    }

    public List<Card> QueryCardall() {

        String sql = "select *from card ";
        return DBhelper.query(sql, new BeanListHandler<>(Card.class));
    }

    public Long QueryCardcount() {

        String sql = "select count(*)from card ";
        return DBhelper.query(sql, new ScalarHandler<Long>());
    }

    public List<String> QueryCardname() {

        String sql = "select name from card ";
        return DBhelper.query(sql, new ColumnListHandler<String>());
    }


}
