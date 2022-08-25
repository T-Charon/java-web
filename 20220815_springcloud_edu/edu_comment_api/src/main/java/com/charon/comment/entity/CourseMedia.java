package com.charon.comment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 课节视频表
 * @TableName course_media
 */
@TableName(value ="course_media")
@Data
public class CourseMedia implements Serializable {
    /**
     * 课程媒体主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课程Id
     */
    @TableField(value = "course_id")
    private Integer courseId;

    /**
     * 章ID
     */
    @TableField(value = "section_id")
    private Integer sectionId;

    /**
     * 课时ID
     */
    @TableField(value = "lesson_id")
    private Integer lessonId;

    /**
     * 封面图URL
     */
    @TableField(value = "cover_image_url")
    private String coverImageUrl;

    /**
     * 时长（06:02）
     */
    @TableField(value = "duration")
    private String duration;

    /**
     * 媒体资源文件对应的EDK
     */
    @TableField(value = "file_edk")
    private String fileEdk;

    /**
     * 文件大小MB
     */
    @TableField(value = "file_size")
    private Double fileSize;

    /**
     * 文件名称
     */
    @TableField(value = "file_name")
    private String fileName;

    /**
     * 媒体资源文件对应的DK
     */
    @TableField(value = "file_dk")
    private String fileDk;

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
     * 是否删除，0未删除，1删除
     */
    @TableField(value = "is_del")
    private Boolean isDel;

    /**
     * 时长，秒数（主要用于音频在H5控件中使用）
     */
    @TableField(value = "duration_num")
    private Integer durationNum;

    /**
     * 媒体资源文件ID
     */
    @TableField(value = "file_id")
    private String fileId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}