package com.blb.mapper;

import com.blb.entity.Book;
import com.blb.entity.BookType;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/13
 **/
public interface BookMapperDao {
    /**
     * 查询所有的书籍
     * @return
     */
    List<Book>list();

    /**
     * 获取所有分类下的图书集合
     */
    List<BookType>getBookByTypeId();
}
