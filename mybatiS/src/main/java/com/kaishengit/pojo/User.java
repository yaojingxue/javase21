package com.kaishengit.pojo;

import java.io.Serializable;

/**
 * Created by acer on 2017/4/11.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1633010262852550215L;
    private   Integer id;
    private   String name;
    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }


    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + pwd + '\'' +
                '}';
    }

}
