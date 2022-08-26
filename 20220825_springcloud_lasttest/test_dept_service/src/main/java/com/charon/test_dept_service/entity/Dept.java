package com.charon.test_dept_service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName dept
 */
@TableName(value ="dept")
@Data
public class Dept implements Serializable {
    /**
     * 部门id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门名称
     */
    @TableField(value = "dept_name")
    private String deptName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}