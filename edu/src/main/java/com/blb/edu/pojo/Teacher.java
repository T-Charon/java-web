package com.blb.edu.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 讲师表
 * @TableName teacher
 */
@Data
public class Teacher implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 讲师姓名
     */
    private String teacherName;

    /**
     * 职务
     */
    private String position;

    /**
     * 讲师介绍
     */
    private String description;

    /**
     * 记录创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Boolean isDel;

    private static final long serialVersionUID = 1L;
}