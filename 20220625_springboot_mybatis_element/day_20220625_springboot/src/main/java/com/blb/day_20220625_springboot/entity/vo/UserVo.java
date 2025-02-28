package com.blb.day_20220625_springboot.entity.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Charon
 * @Date 2022/6/27
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {

    private String userName;
    private String token;

}
