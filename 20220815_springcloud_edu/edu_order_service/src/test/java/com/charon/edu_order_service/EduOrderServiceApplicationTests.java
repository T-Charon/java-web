package com.charon.edu_order_service;

import com.charon.comment.entity.UserCourseOrder;
import com.charon.edu_order_service.mapper.UserCourseOrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class EduOrderServiceApplicationTests {
    @Autowired(required = false)
    UserCourseOrderMapper userCourseOrderMapper;

    @Test
    void testInsertOrder() {
        for (int i = 0; i < 20; i++) {
            UserCourseOrder userCourseOrder = new UserCourseOrder(0L, 0L, 0L, 0L, (byte) 0, LocalDateTime.now(),
                    LocalDateTime.now(), (byte) 0, "xx" + i, 1, 1L);
            userCourseOrderMapper.insertOrder(userCourseOrder);
        }
    }

    @Test
    void testSelectOrder(){
        List<UserCourseOrder> userCourseOrders = userCourseOrderMapper.selectOrderLimit(0, 20);
        userCourseOrders.forEach(System.out::println);
    }

}
