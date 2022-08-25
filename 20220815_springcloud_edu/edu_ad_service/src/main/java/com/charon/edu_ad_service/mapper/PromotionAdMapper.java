package com.charon.edu_ad_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.charon.comment.entity.PromotionAd;

/**
 * @Entity com.charon.comment.entity.PromotionAd
 */
public interface PromotionAdMapper extends BaseMapper<PromotionAd> {
    /**
     * 分页
     * @param page
     * @return
     */
    IPage<PromotionAd> getList(IPage page);
}




