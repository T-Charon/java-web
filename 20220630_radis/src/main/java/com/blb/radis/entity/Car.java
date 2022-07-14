package com.blb.radis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Charon
 * @Date 2022/6/30
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {

    private Long id;
    private String number;
    private double price;
    private String brand;
    private Long power;

}

