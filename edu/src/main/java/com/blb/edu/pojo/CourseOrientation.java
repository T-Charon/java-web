package com.blb.edu.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName course_orientation
 */
@Data
public class CourseOrientation implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String orientationName;

    /**
     * 
     */
    private Integer parentId;

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
        CourseOrientation other = (CourseOrientation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrientationName() == null ? other.getOrientationName() == null : this.getOrientationName().equals(other.getOrientationName()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrientationName() == null) ? 0 : getOrientationName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orientationName=").append(orientationName);
        sb.append(", parentId=").append(parentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}