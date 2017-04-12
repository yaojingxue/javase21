package com.lianxi.test;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by acer on 2017/3/17.
 */
public class LogTestcase {
    @Test
    public  void LogTest(){
        String name ="小明";
        String bookname="<<java从入门到精通>>";
        Logger logger= LoggerFactory.getLogger(LogTestcase.class);
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("{}借阅了{}",name,bookname);
        logger.warn("warn message");
        logger.error("error message");
//        logger.fatal("fatal message");
    }
}
