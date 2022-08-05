package com.blb.edu.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Course other = (Course) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCourseName() == null ? other.getCourseName() == null : this.getCourseName().equals(other.getCourseName()))
            && (this.getBrief() == null ? other.getBrief() == null : this.getBrief().equals(other.getBrief()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getPriceTag() == null ? other.getPriceTag() == null : this.getPriceTag().equals(other.getPriceTag()))
            && (this.getDiscounts() == null ? other.getDiscounts() == null : this.getDiscounts().equals(other.getDiscounts()))
            && (this.getDiscountsTag() == null ? other.getDiscountsTag() == null : this.getDiscountsTag().equals(other.getDiscountsTag()))
            && (this.getCourseDescriptionMarkDown() == null ? other.getCourseDescriptionMarkDown() == null : this.getCourseDescriptionMarkDown().equals(other.getCourseDescriptionMarkDown()))
            && (this.getCourseDescription() == null ? other.getCourseDescription() == null : this.getCourseDescription().equals(other.getCourseDescription()))
            && (this.getCourseImgUrl() == null ? other.getCourseImgUrl() == null : this.getCourseImgUrl().equals(other.getCourseImgUrl()))
            && (this.getIsNew() == null ? other.getIsNew() == null : this.getIsNew().equals(other.getIsNew()))
            && (this.getIsNewDes() == null ? other.getIsNewDes() == null : this.getIsNewDes().equals(other.getIsNewDes()))
            && (this.getLastOperatorId() == null ? other.getLastOperatorId() == null : this.getLastOperatorId().equals(other.getLastOperatorId()))
            && (this.getAutoOnlineTime() == null ? other.getAutoOnlineTime() == null : this.getAutoOnlineTime().equals(other.getAutoOnlineTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getTotalDuration() == null ? other.getTotalDuration() == null : this.getTotalDuration().equals(other.getTotalDuration()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSortNum() == null ? other.getSortNum() == null : this.getSortNum().equals(other.getSortNum()))
            && (this.getPreviewFirstField() == null ? other.getPreviewFirstField() == null : this.getPreviewFirstField().equals(other.getPreviewFirstField()))
            && (this.getPreviewSecondField() == null ? other.getPreviewSecondField() == null : this.getPreviewSecondField().equals(other.getPreviewSecondField()))
            && (this.getSales() == null ? other.getSales() == null : this.getSales().equals(other.getSales()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getOrientationId() == null ? other.getOrientationId() == null : this.getOrientationId().equals(other.getOrientationId()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCourseName() == null) ? 0 : getCourseName().hashCode());
        result = prime * result + ((getBrief() == null) ? 0 : getBrief().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getPriceTag() == null) ? 0 : getPriceTag().hashCode());
        result = prime * result + ((getDiscounts() == null) ? 0 : getDiscounts().hashCode());
        result = prime * result + ((getDiscountsTag() == null) ? 0 : getDiscountsTag().hashCode());
        result = prime * result + ((getCourseDescriptionMarkDown() == null) ? 0 : getCourseDescriptionMarkDown().hashCode());
        result = prime * result + ((getCourseDescription() == null) ? 0 : getCourseDescription().hashCode());
        result = prime * result + ((getCourseImgUrl() == null) ? 0 : getCourseImgUrl().hashCode());
        result = prime * result + ((getIsNew() == null) ? 0 : getIsNew().hashCode());
        result = prime * result + ((getIsNewDes() == null) ? 0 : getIsNewDes().hashCode());
        result = prime * result + ((getLastOperatorId() == null) ? 0 : getLastOperatorId().hashCode());
        result = prime * result + ((getAutoOnlineTime() == null) ? 0 : getAutoOnlineTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getTotalDuration() == null) ? 0 : getTotalDuration().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSortNum() == null) ? 0 : getSortNum().hashCode());
        result = prime * result + ((getPreviewFirstField() == null) ? 0 : getPreviewFirstField().hashCode());
        result = prime * result + ((getPreviewSecondField() == null) ? 0 : getPreviewSecondField().hashCode());
        result = prime * result + ((getSales() == null) ? 0 : getSales().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getOrientationId() == null) ? 0 : getOrientationId().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseName=").append(courseName);
        sb.append(", brief=").append(brief);
        sb.append(", price=").append(price);
        sb.append(", priceTag=").append(priceTag);
        sb.append(", discounts=").append(discounts);
        sb.append(", discountsTag=").append(discountsTag);
        sb.append(", courseDescriptionMarkDown=").append(courseDescriptionMarkDown);
        sb.append(", courseDescription=").append(courseDescription);
        sb.append(", courseImgUrl=").append(courseImgUrl);
        sb.append(", isNew=").append(isNew);
        sb.append(", isNewDes=").append(isNewDes);
        sb.append(", lastOperatorId=").append(lastOperatorId);
        sb.append(", autoOnlineTime=").append(autoOnlineTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", totalDuration=").append(totalDuration);
        sb.append(", status=").append(status);
        sb.append(", sortNum=").append(sortNum);
        sb.append(", previewFirstField=").append(previewFirstField);
        sb.append(", previewSecondField=").append(previewSecondField);
        sb.append(", sales=").append(sales);
        sb.append(", typeId=").append(typeId);
        sb.append(", orientationId=").append(orientationId);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}