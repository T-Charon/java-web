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
}