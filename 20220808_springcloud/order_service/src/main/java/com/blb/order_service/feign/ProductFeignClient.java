package com.blb.order_service.feign;

import com.blb.order_service.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Charon
 * @Date 2022/8/10
 **/

@FeignClient("product-server")
public interface ProductFeignClient {

    @GetMapping("/product/{id}")
    ResponseEntity<Product> getProduct(@PathVariable Long id);
}
