package com.charon.test_position_service.feign;

import com.charon.test_position_service.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Charon
 * @Date 2022/8/25
 **/
@FeignClient("test-dept-service")
public interface DeptFeignClient {
    /**
     * 根据id查询部门
     * @return
     */
    @GetMapping("getDeptById/{id}")
    Dept getDeptById(@PathVariable int id);
}
