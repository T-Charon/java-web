package com.blb.day_20220625_springboot.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("s_product")
public class Product {


  @TableId(type = IdType.INPUT)
  private String id;
  private String productName;
  private String productImage;
  private Double price;
  private String productType;
  private String productDesc;
  private LocalDateTime createTime;
  private String productBrand;


}
