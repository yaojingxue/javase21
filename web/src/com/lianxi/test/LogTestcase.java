package com.lianxi.test;

import org.apache.log4j.Logger;
import org.junit.Test;



/**
 * Created by acer on 2017/3/17.
 */
public class LogTestcase {
    @Test
    public  void LogTest(){
        Logger logger=Logger.getLogger(LogTestcase.class);
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
        logger.fatal("fatal message");
    }
}
