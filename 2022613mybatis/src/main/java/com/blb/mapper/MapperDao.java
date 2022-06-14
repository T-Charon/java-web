package com.blb.mapper;

import com.blb.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/13
 **/
public interface MapperDao {


    List<User> list();

    @Insert("insert into t_user(name,pwd)values(#{name},#{pwd}) ")
    void add(User user);

    @Update("update t_user set name=#{name},pwd =#{pwd} where id=#{id}")
    void update(User user);

    @Delete("delete from t_user where id=#{id}")
    void delete(int id);

    /**
     * 根据条件查询
     * @param user
     * @return
     */
    List<User> get(User user);

    /**
     * 动态更新
     * @param user
     */
    void update1(User user);

    /**
     *
     * @param user
     */
    void addList(List<User> user);


}
