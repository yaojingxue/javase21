package com.lianxi.test;

import com.CardDAO;
import com.entity.Card;
import org.junit.Test;

/**
 * Created by acer on 2017/3/16.
 */
public class CardDAOTest {
    private CardDAO cardDAO=new CardDAO();
    @Test
    public void dataCardsaveTest(){
        Card card=new Card();
        card.setCardnumber("A396");
        card.setName("李小海");
        card.setTel("456987");
        cardDAO.dataCardsave(card);
    }
    @Test
    public void dataCarddeleteTest(){


        cardDAO.dataCarddelete(19);
    }
    @Test
    public  void dataCardupdateTest(){
        Card card=new Card();
        card.setId(17);
        card.setName("贾乃亮");
        card.setCardnumber("A140");
        card.setTel("16987");
        cardDAO.dataCardupdate(card);
    }
    @Test
    public  void QueryCardone(){
        cardDAO.QueryCardone("贾乃亮");
        //System.out.println(cardDAO.QueryCardone("贾乃亮"));
    }
    @Test
    public  void QueryCardall(){
        cardDAO.QueryCardall();
        System.out.println(cardDAO.QueryCardall());
    }
    @Test
    public  void QueryCardcount(){
        cardDAO.QueryCardcount();

        System.out.println(cardDAO.QueryCardcount());
    }
    @Test
    public  void QueryCardname(){
        cardDAO.QueryCardname();

        System.out.println(cardDAO.QueryCardcount());
    }



}

