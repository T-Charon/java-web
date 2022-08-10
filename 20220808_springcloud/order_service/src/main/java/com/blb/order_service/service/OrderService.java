package com.blb.order_service.service;

import com.blb.order_service.entity.Order;
import com.blb.order_service.entity.Product;
import com.blb.order_service.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Author Charon
 * @Date 2022/8/8
 **/
@Service
public class OrderService {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductFeignClient productFeignClient;

    public Order getOrderById(Long id){
        Order order = new Order(id, 88L, 100, LocalDateTime.now(), null);
        //调用商品服务查询商品
//        ResponseEntity<Product> entity = restTemplate.getForEntity("http://product-server/product/" + order.getProductId(),
//                Product.class);
        //调用远程服务
        ResponseEntity<Product> product = productFeignClient.getProduct(id);
        order.setProduct(product.getBody());
        return order;

    }

}
