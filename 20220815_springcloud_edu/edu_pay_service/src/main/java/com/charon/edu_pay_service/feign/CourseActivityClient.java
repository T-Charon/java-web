package com.charon.edu_pay_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Charon
 * @Date 2022/8/31
 **/
@FeignClient("course-service")
public interface CourseActivityClient {
    /**
     * 支付成功后调用修改库存
     * @param activityId
     * @param num
     * @return
     */
    @PutMapping("courseActivity/updateStock")
    ResponseEntity<Boolean> changeStock(@RequestParam Long activityId, @RequestParam long num);


    /**
     * 支付成功后调用修改销量
     * @param id
     * @param sales
     * @return
     */
    @PutMapping("course/sales")
    ResponseEntity<Boolean> updateSales(@RequestParam Long id , @RequestParam Integer sales);
}
