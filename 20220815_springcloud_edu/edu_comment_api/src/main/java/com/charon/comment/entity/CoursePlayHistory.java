package com.charon.comment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName course_play_history
 */
@TableName(value ="course_play_history")
@Data
public class CoursePlayHistory implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;

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
     * 课时id
     */
    @TableField(value = "lesson_id")
    private Integer lessonId;

    /**
     * 历史播放节点(s)
     */
    @TableField(value = "history_node")
    private Integer historyNode;

    /**
     * 最高历史播放节点
     */
    @TableField(value = "history_highest_node")
    private Integer historyHighestNode;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}