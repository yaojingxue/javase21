package com.kaishengit.test;

import com.kaishengit.DAO.userDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by acer on 2017/4/13.
 */
public class userDaoTestCase {
    @Test
    public void testsave() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        userDao dao= (userDao)context.getBean("userdao");
        //dao.save();

    }
}
