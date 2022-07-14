package com.example.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.test.entity.Info;


import java.util.List;

/**
 * @Author Charon
 * @Date 2022/7/13
 **/

public interface IInfoService extends IService<Info> {

    List<Info> getList();
}
