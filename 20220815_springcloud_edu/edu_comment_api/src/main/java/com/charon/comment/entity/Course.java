package com.charon.comment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 课程
 * @TableName course
 */

@TableName(value ="course")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course implements Serializable {

    /**
     * 课程方向
     */
    @TableField(exist = false)
    private CourseOrientation orientation;

    /**
     * 课程类型
     */
    @TableField(exist = false)
    private CourseType type;
    /**
     * 讲师
     */
    @TableField(exist = false)
    private Teacher teacher;

    /**
     *章节
     */
    @TableField(exist = false)
    private List<CourseSection> courseSections;

    /**
     *课程活动
     */
    @TableField(exist = false)
    private CourseActivity courseActivity;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 课程名称
     */
    @TableField(value = "course_name")
    private String courseName;

    /**
     * 介绍
     */
    @TableField(value = "brief")
    private String brief;

    /**
     * 价格
     */
    @TableField(value = "price")
    private Double price;

    /**
     * 价格标签
     */
    @TableField(value = "price_tag")
    private String priceTag;

    /**
     * 折扣
     */
    @TableField(value = "discounts")
    private Double discounts;

    /**
     * 折扣标签
     */
    @TableField(value = "discounts_tag")
    private String discountsTag;

    /**
     * 介绍markdown
     */
    @TableField(value = "course_description_mark_down")
    private String courseDescriptionMarkDown;

    /**
     * 详细介绍
     */
    @TableField(value = "course_description")
    private String courseDescription;

    /**
     * 课程地址
     */
    @TableField(value = "course_img_url")
    private String courseImgUrl;

    /**
     * 是否新课程
     */
    @TableField(value = "is_new")
    private Boolean isNew;

    /**
     * 新课描述
     */
    @TableField(value = "is_new_des")
    private String isNewDes;

    /**
     * 操作id
     */
    @TableField(value = "last_operator_id")
    private Integer lastOperatorId;

    /**
     * 上线时间
     */
    @TableField(value = "auto_online_time")
    private LocalDateTime autoOnlineTime;

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
    private Boolean isDel;

    /**
     * 总时长
     */
    @TableField(value = "total_duration")
    private Integer totalDuration;

    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 序号
     */
    @TableField(value = "sort_num")
    private Integer sortNum;

    /**
     * 预览一
     */
    @TableField(value = "preview_first_field")
    private String previewFirstField;

    /**
     * 预览二
     */
    @TableField(value = "preview_second_field")
    private String previewSecondField;

    /**
     * 销量
     */
    @TableField(value = "sales")
    private Integer sales;

    /**
     * 类型id
     */
    @TableField(value = "type_id")
    private Integer typeId;

    /**
     * 方向id
     */
    @TableField(value = "orientation_id")
    private Integer orientationId;

    /**
     * 老师id
     */
    @TableField(value = "teacher_id")
    private Integer teacherId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}