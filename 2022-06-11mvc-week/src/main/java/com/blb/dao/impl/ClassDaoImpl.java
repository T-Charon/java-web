package com.blb.dao.impl;

import com.blb.dao.ClassDao;
import com.blb.entity.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/11
 **/

@Repository
public class ClassDaoImpl implements ClassDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Class> list() {
        List<Class> list = jdbcTemplate.query("select c.id,c.class_name,count(s.id)count from t_class c\n" +
                "                left join t_student s\n" +
                "                on c.id = s.class_id\n" +
                "                group by c.id", new BeanPropertyRowMapper<>(Class.class));
        return list;
    }

    @Override
    public List<Class> getByName(String name) {
        List<Class> list = jdbcTemplate.query("select * from t_class where class_name = ?", new BeanPropertyRowMapper<>(Class.class),name);
        return list;
    }

    @Override
    public void updateClass(Class classInfo) {
        jdbcTemplate.update("update t_class set class_name=? where id= ?",classInfo.getClassName(),classInfo.getId());
    }

    @Override
    public void deleteClass(int id) {
        jdbcTemplate.update("delete from t_class  where id= ?",id);
    }

}
