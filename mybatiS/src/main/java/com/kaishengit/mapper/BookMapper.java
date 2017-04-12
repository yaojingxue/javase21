package com.kaishengit.mapper;

import com.kaishengit.pojo.Book;

import java.util.List;

/**
 * Created by acer on 2017/4/12.
 */
public interface BookMapper {
    void batchAdd(List<Book> booklist);
    List<Book> findByIds(List<Integer> list);
}
