package com.blb.springboot.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @TableId(type = IdType.AUTO)
  private long articleId;
  private String title;
  private String articleContent;
  private java.sql.Timestamp releaseTime;


  //文章评论
  @TableField(exist = false)
  private List<Comment> comments;



}
