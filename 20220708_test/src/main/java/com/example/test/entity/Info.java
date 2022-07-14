package com.example.test.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Info {

  @TableId(type = IdType.AUTO)
  private Long code;
  private Long directorId;
  private String goodsName;
  private double price;
  private Long orderId;
  private String time;

  @TableField(exist = false)
  private String director;


}
