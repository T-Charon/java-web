package com.blb.radis;

import com.blb.radis.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Test
    void contextLoads() {
        Car car = new Car(1L,"A88888",10000,"bc",1000L);
        //string类型的操作对象
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set("Car:"+car.getId(),car);

        Object value = ops.get("Car:" + 1);
        System.out.println(value);
    }

}
