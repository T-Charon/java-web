package com.charon.edu_ad_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.charon.comment.entity.PromotionAd;

import java.util.List;

/**
 *
 */
public interface PromotionAdService extends IService<PromotionAd> {
    /**
     * 根据spaceid查询广告列表
     * @param sid
     * @return
     */

    List<PromotionAd> getList(Integer sid);
}
