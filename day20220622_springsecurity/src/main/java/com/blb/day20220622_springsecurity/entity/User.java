package com.blb.day20220622_springsecurity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author Charon
 * @Date 2022/6/22
 **/

@Data
@TableName("s_user")
public class User {

    @TableId(type = IdType.INPUT)
    private String id;
    private String username;
    private String password;
    private int type;

}
