package com.blb.edu.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName course_type
 */
@Data
public class CourseType implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String typeName;

    private static final long serialVersionUID = 1L;
}