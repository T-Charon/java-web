package com.blb.day_20220625_springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Charon
 * @Date 2022/6/25
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("s_user")
public class User {
    @TableId(type = IdType.INPUT)
    private String id;
    private String username;
    private String password;
    private Integer type;
}
