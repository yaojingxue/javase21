package com.kaishengit.test.mybatisTestcase;

import com.google.common.collect.Lists;
import com.kaishengit.mapper.BookMapper;
import com.kaishengit.pojo.Book;
import com.kaishengit.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by acer on 2017/4/12.
 */
public class MyBatisBookCase {
    private Logger logger=  LoggerFactory.getLogger(MyBatisBookCase.class);
    @Test
    public void testfindByIds(){
        SqlSession session= MyBatisUtil.getSqlSession();
        BookMapper bookMapper=session.getMapper(BookMapper.class);
        List<Integer> list=Lists.newArrayList();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
         List<Book> booklist=bookMapper.findByIds(list);
        for (Book b:booklist
             ) {
            logger.debug("{}",b);
        }
        session.close();
    }
    @Test
    public void testbatchAdd(){
        SqlSession session= MyBatisUtil.getSqlSession();
        BookMapper bookMapper=session.getMapper(BookMapper.class);
        List<Book> list= Lists.newArrayList();
        list.add(new Book("英语"));
        list.add(new Book("数学"));
        list.add(new Book("语文"));
        list.add(new Book("地理"));
        list.add(new Book("历史"));
        bookMapper.batchAdd(list);
        session.commit();
        for (Book b:list
             ) {
            logger.debug("{}",b);
        }
        session.close();


    }
}
