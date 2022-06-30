package com.blb.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LLogistic {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String goodsId;
  private LocalDateTime deliveryTime;
  private LocalDateTime arrivalTime;
  private Integer number;
  private String addressDeliveryId;
  private String addressArrivalId;

  public String getDeliveryTime() {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(deliveryTime);
  }

  public String getArrivalTime() {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(arrivalTime);
  }
}
