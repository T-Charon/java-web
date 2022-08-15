package com.blb.mysql_promotion_service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blb.comment.entity.PromotionSpace;

/**
 *
 */
public interface PromotionSpaceService extends IService<PromotionSpace> {
    IPage<PromotionSpace> getList(int current, int size);
}
