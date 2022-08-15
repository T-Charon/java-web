package com.blb.mysql_promotion_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.comment.entity.PromotionAd;

/**
 * @Entity com.blb.comment.entity.PromotionAd
 */
public interface PromotionAdMapper extends BaseMapper<PromotionAd> {

    /**
     * 分页
     * @param page
     * @return
     */
    IPage<PromotionAd> getList(IPage page);
}




