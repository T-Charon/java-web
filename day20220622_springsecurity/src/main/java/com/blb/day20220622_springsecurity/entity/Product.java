package com.blb.day20220622_springsecurity.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("s_product")
public class Product {

  @TableId(type = IdType.INPUT)
  private String id;
  private String productName;
  private String productImage;
  private double price;
  private String productType;
  private String productDesc;
  private LocalDateTime createTime;
  private String productBrand;




}
