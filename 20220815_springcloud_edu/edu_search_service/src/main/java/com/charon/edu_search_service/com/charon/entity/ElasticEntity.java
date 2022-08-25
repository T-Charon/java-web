package com.charon.edu_search_service.com.charon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Charon
 * @Date 2022/8/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElasticEntity {
    private String id;

    private Object data;
}
