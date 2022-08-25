package com.charon.comment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 活动课程表
 * @TableName course_activity
 */
@TableName(value ="course_activity")
@Data
public class CourseActivity implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课程ID
     */
    @TableField(value = "course_id")
    private Integer courseId;

    /**
     * 活动开始时间
     */
    @TableField(value = "begin_time")
    private LocalDateTime beginTime;

    /**
     * 活动结束时间
     */
    @TableField(value = "end_time")
    private LocalDateTime endTime;

    /**
     * 活动价格
     */
    @TableField(value = "amount")
    private Integer amount;

    /**
     * 库存值
     */
    @TableField(value = "stock")
    private Integer stock;

    /**
     * 状态 0未上架 10已上架
     */
    @TableField(value = "status")
    private Byte status;

    /**
     * 逻辑删除 0未删除 1删除
     */
    @TableField(value = "is_del")
    private Boolean isDel;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}