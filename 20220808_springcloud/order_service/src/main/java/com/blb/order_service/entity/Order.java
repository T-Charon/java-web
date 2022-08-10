package com.blb.order_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author Charon
 * @Date 2022/8/8
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private long productId;
    private int count;
    private LocalDateTime time;

    private Product product;
}
