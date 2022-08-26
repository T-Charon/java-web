package com.charon.test_position_service.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName position
 */
@TableName(value ="position")
@Data
public class Position implements Serializable {

    @TableField(exist = false)
    private Dept dept;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门id
     */
    @TableField(value = "dept_id")
    private Integer deptId;

    /**
     * 职位名
     */
    @TableField(value = "position_name")
    private String positionName;

    /**
     * 岗位级别
     */
    @TableField(value = "Job_level")
    private String jobLevel;

    /**
     * 逻辑删除
     */
    @TableLogic
    @TableField(value = "delete_flag")
    private Integer deleteFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}