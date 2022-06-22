package com.blb.thymeleaf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author Charon
 * @Date 2022/6/20
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;
    private String productName;
    private String productImage;
    private Double price;
    private String productType;
    private String productDesc;
    private LocalDateTime createTime;
    private String productBrand;


}
