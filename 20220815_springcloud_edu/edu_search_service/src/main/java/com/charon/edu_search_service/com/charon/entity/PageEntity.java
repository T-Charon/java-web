package com.charon.edu_search_service.com.charon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/8/23
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageEntity<T> {
    private long current;
    private long total;
    private  long pageSize;
    private List<T> data;
}
