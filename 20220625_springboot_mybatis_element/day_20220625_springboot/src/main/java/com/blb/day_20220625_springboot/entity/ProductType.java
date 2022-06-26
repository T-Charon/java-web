package com.blb.day_20220625_springboot.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("s_product_type")
public class ProductType {

  @TableId(type = IdType.INPUT)
  private String id;
  private String productTypeName;
  private String productTypeDesc;
  private String productTypeIcon;


}
