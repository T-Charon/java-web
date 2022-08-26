package com.charon.test_position_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.charon.test_position_service.entity.Position;

import java.util.List;

/**
 *
 */
public interface PositionService extends IService<Position> {
    List<Position> getPosition();

}
