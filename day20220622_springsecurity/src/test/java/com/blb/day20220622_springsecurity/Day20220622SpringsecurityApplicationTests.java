package com.blb.day20220622_springsecurity;

import com.blb.day20220622_springsecurity.entity.User;
import com.blb.day20220622_springsecurity.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class Day20220622SpringsecurityApplicationTests {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Test
    void contextLoads() {

        String s = bCryptPasswordEncoder.encode("123456");
        System.out.println(s);
    }

    @Autowired
    private UserMapper userMapper;
    @Test
    void test(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }


}
