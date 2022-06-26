package com.blb.day_20220625_springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blb.day_20220625_springboot.entity.Person;
import com.blb.day_20220625_springboot.mapper.PersonMapper;
import com.blb.day_20220625_springboot.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author Charon
 * @Date 2022/6/23
 **/
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public IPage<Person> getPage(Long current, Long size) {
        return personMapper.selectPersonPage(new Page<>(current,size));
    }
}
