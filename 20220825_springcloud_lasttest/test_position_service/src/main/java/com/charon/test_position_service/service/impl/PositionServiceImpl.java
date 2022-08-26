package com.charon.test_position_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.charon.test_position_service.entity.Dept;
import com.charon.test_position_service.entity.Position;
import com.charon.test_position_service.feign.DeptFeignClient;
import com.charon.test_position_service.mapper.PositionMapper;
import com.charon.test_position_service.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position>
    implements PositionService{

    @Autowired
    private DeptFeignClient deptFeignClient;

    @Autowired
    private PositionMapper positionMapper;
    @Override
    public List<Position> getPosition() {
        List<Position> lists = list();
        for (Position list:lists) {
            Integer deptId = list.getDeptId();
            //调用远程
            Dept deptInfo = deptFeignClient.getDeptById(deptId);
            list.setDept(deptInfo);
        }
        return lists;
    }
}




