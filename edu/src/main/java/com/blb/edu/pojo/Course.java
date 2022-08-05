package com.blb.edu.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程
 * @TableName course
 */
@Data
public class Course implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 介绍
     */
    private String brief;

    /**
     * 价格
     */
    private Double price;

    /**
     * 价格标签
     */
    private String priceTag;

    /**
     * 折扣
     */
    private Double discounts;

    /**
     * 折扣标签
     */
    private String discountsTag;

    /**
     * 介绍markdown
     */
    private String courseDescriptionMarkDown;

    /**
     * 详细介绍
     */
    private String courseDescription;

    /**
     * 课程地址
     */
    private String courseImgUrl;

    /**
     * 是否新课程
     */
    private Boolean isNew;

    /**
     * 新课描述
     */
    private String isNewDes;

    /**
     * 操作id
     */
    private Integer lastOperatorId;

    /**
     * 上线时间
     */
    private Date autoOnlineTime;

    /**
     * 创建时间
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

    /**
     * 总时长
     */
    private Integer totalDuration;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 序号
     */
    private Integer sortNum;

    /**
     * 预览一
     */
    private String previewFirstField;

    /**
     * 预览二
     */
    private String previewSecondField;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 类型id
     */
    private Integer typeId;

    /**
     * 方向id
     */
    private Integer orientationId;

    /**
     * 老师id
     */
    private Integer teacherId;

    private static final long serialVersionUID = 1L;
}