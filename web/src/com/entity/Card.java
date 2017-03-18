package com.entity;

/**
 * Created by acer on 2017/3/15.
 */
public class Card {
    Integer id;
    String cardnumber;
    String name;
    String tel;

    public Card() {}

    public Card(Integer id, String cardnumber, String name, String tel) {
        this.id = id;
        this.cardnumber = cardnumber;
        this.name = name;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardnumber='" + cardnumber + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
