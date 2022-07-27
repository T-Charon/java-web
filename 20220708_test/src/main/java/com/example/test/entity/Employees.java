package com.example.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Employees {

  @TableId(type = IdType.AUTO)
  private Long id;
  private String name;
  private Long age;
  private String sex;
  private String commencementDate;
  private String address;
  private Long deptId;

  @TableField(exist = false)
  private String deptName;



}
