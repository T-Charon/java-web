package com.charon.edu_user_service.entity;

import com.charon.comment.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Charon
 * @Date 2022/8/11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenVO {

    private String username;
    private String token;
    private User user;
}
