package com.blb.mysql_promotion_service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blb.comment.entity.PromotionAd;

/**
 *
 */
public interface PromotionAdService extends IService<PromotionAd> {
    IPage<PromotionAd> getList(int current, int size);
}
