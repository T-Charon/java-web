package com.charon.comment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @author Charon
 * @TableName course_orientation
 */
@TableName(value ="course_orientation")
@Data
public class CourseOrientation implements Serializable {

    /**
     *父级方向
     */
    @TableField(exist = false)
    private CourseOrientation parent;
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "orientation_name")
    private String orientationName;

    /**
     * 
     */
    @TableField(value = "parent_id")
    private Integer parentId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}