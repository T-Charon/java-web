package com.blb.mapper;

import com.blb.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/14
 **/

public interface UserMapperDao {
    @Select("select * from t_user")
    List<User> list();
}
