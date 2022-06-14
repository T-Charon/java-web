package com.blb.test;

import com.blb.entity.User;
import com.blb.mapper.MapperDao;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * @Author Charon
 * @Date 2022/6/13
 **/
public class Test {



    public static void main(String[] args) throws IOException {


        //1.加载mybatis的核心配置文件
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MapperDao mapperDao = sqlSession.getMapper(MapperDao.class);



        //新增
       /* User user = new User();
        user.setName("小米");
        user.setPwd("123");
        mapperDao.add(user);*/

        //修改
       /* mapperDao.update(new User(2,"小琴","456"));*/

        //删除
     /*    mapperDao.delete(1);*/

        //按条件查询
       /* User user = new User();
        user.setName("三");
        user.setPwd("123");
        System.out.println(mapperDao.get(user));*/

        //动态更新
       /* User user = new User();
        user.setId(1);
        user.setName("zs");
        mapperDao.update1(user);*/

       //批量插入
      /*  ArrayList<User> list = new ArrayList<User>();
        for (int i = 0; i <5 ; i++) {
            User user = new User();
            user.setName("张三"+i);
            user.setPwd("1000"+i);
            list.add(user);
        }
        mapperDao.addList(list);*/


        //查询
        System.out.println(mapperDao.list());
        sqlSession.commit();

    }
}
