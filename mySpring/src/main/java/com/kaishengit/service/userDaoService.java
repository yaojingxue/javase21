package com.kaishengit.service;

import com.kaishengit.DAO.userDao;

/**
 * Created by acer on 2017/4/13.
 */
public class userDaoService {
    private userDao userDao;

    public void setUserDao(com.kaishengit.DAO.userDao userDao) {
        this.userDao = userDao;
    }
    public void serviceSave(){
        userDao.save();
    }
}
