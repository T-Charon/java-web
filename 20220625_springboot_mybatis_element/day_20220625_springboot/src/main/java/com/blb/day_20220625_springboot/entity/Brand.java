package com.blb.day_20220625_springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("s_brand")
public class Brand {

  @TableId(type = IdType.INPUT)
  private String id;
  private String brandName;
  private String brandType;
  private String brandImg;




}
