package com.blb.mysql_promotion_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.comment.entity.PromotionSpace;

/**
 * @Entity com.blb.comment.entity.PromotionSpace
 */
public interface PromotionSpaceMapper extends BaseMapper<PromotionSpace> {
    IPage<PromotionSpace> getList(IPage page);
}




