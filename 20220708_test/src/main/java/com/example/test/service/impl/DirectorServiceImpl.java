package com.example.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test.entity.Director;
import com.example.test.entity.Info;
import com.example.test.mapper.DirectorMapper;
import com.example.test.mapper.InfoMapper;
import com.example.test.service.IDirectorService;
import com.example.test.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/7/13
 **/
@Service
public class DirectorServiceImpl extends ServiceImpl<DirectorMapper, Director> implements IDirectorService {

    @Autowired
    private DirectorMapper directorMapper;

}
