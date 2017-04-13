package com.kaishengit.test;

import com.kaishengit.service.userDaoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by acer on 2017/4/13.
 */
public class userServiceTestCase {
    @Test
    public void testServicesave(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        userDaoService userDaoService=(userDaoService)context.getBean("userService");
        userDaoService.serviceSave();
    }
}
