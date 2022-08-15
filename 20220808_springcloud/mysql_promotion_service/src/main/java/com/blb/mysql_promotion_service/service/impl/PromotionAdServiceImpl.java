package com.blb.mysql_promotion_service.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blb.comment.entity.PromotionAd;
import com.blb.mysql_promotion_service.service.PromotionAdService;
import com.blb.mysql_promotion_service.mapper.PromotionAdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class PromotionAdServiceImpl extends ServiceImpl<PromotionAdMapper, PromotionAd>
    implements PromotionAdService{

    @Autowired
    private PromotionAdMapper promotionAdMapper;
    @Override
    public IPage<PromotionAd> getList(int current, int size) {
        return promotionAdMapper.getList(new Page(current,size));
    }
}




