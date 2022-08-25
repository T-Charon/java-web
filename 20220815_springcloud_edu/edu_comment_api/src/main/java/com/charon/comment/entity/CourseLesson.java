package com.charon.comment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 课程节内容
 * @TableName course_lesson
 */
@TableName(value ="course_lesson")
@Data
public class CourseLesson implements Serializable {
    /**
     *每小节对应的视频
     */
    @TableField(exist = false)
    private CourseMedia courseMedia;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课程id
     */
    @TableField(value = "course_id")
    private Integer courseId;

    /**
     * 章节id
     */
    @TableField(value = "section_id")
    private Integer sectionId;

    /**
     * 课时主题
     */
    @TableField(value = "theme")
    private String theme;

    /**
     * 课时时长(分钟)
     */
    @TableField(value = "duration")
    private Integer duration;

    /**
     * 是否免费
     */
    @TableField(value = "is_free")
    private Boolean isFree;

    /**
     * 记录创建时间
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
     * 排序字段
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 课时状态,0-隐藏，1-未发布，2-已发布
     */
    @TableField(value = "status")
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}