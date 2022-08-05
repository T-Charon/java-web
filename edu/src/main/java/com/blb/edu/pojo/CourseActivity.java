package com.blb.edu.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动课程表
 * @TableName course_activity
 */
@Data
public class CourseActivity implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 课程ID
     */
    private Integer courseId;

    /**
     * 活动开始时间
     */
    private Date beginTime;

    /**
     * 活动结束时间
     */
    private Date endTime;

    /**
     * 活动价格
     */
    private Integer amount;

    /**
     * 库存值
     */
    private Integer stock;

    /**
     * 状态 0未上架 10已上架
     */
    private Byte status;

    /**
     * 逻辑删除 0未删除 1删除
     */
    private Boolean isDel;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}