package com.blb.day_20220625_springboot;

import com.blb.day_20220625_springboot.utils.JwtUtil;
import com.blb.day_20220625_springboot.utils.RsaUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class Day20220625SpringbootApplicationTests {

    @Test
    void contextLoads() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println(encode);
    }

}
