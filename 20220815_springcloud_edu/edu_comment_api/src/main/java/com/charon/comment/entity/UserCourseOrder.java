package com.charon.comment.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户课程订单表
 * @TableName user_course_order
 */
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="user_course_order")
@Data
public class UserCourseOrder implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 课程id，根据订单中的课程类型来选择
     */
    @TableField(value = "course_id")
    private Long courseId;

    /**
     * 
     */
    @TableField(value = "activity_id")
    private Long activityId;

    /**
     * 当前状态: 0未支付 1已支付 2已取消 3已过期 
     */
    @TableField(value = "status")
    private Byte status;

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

    /**
     * 是否删除
     */
    @TableField(value = "is_del")
    private Byte isDel;

    /**
     * 
     */
    @TableField(value = "trade_no")
    private String tradeNo;

    /**
     * 
     */
    @TableField(value = "pay_type_id")
    private Integer payTypeId;

    /**
     * 
     */
    @TableField(value = "price")
    private Long price;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}