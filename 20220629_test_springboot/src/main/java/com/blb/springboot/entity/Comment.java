package com.blb.springboot.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

  private long id;
  private String content;
  private java.sql.Timestamp time;
  private long articleId;


}
