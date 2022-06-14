package com.blb.test;

import com.blb.mapper.BookMapperDao;
import com.blb.mapper.MapperDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Charon
 * @Date 2022/6/13
 **/
public class BookTest {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis的核心配置文件
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapperDao bookMapperDao = sqlSession.getMapper(BookMapperDao.class);

        //查询所有书籍
        /*System.out.println(bookMapperDao.list());*/

        //查询所有分类下的图书
        System.out.println(bookMapperDao.getBookByTypeId());

    }


}
