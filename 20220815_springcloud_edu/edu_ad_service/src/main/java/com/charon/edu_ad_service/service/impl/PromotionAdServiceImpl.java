package com.charon.edu_ad_service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.charon.comment.entity.PromotionAd;
import com.charon.edu_ad_service.mapper.PromotionAdMapper;
import com.charon.edu_ad_service.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *配置缓存名称是promotions
 */
@CacheConfig(cacheNames = "promotions")
@Service
public class PromotionAdServiceImpl extends ServiceImpl<PromotionAdMapper, PromotionAd>
    implements PromotionAdService{

    @Autowired
    private PromotionAdMapper promotionAdMapper;


    /**
     * 根据spaceid查询广告列表
     * @param sid
     * @return
     */
    @Cacheable(cacheNames = "ad-list",key = "T(String).valueOf(#sid)")
    @Override
    public List<PromotionAd> getList(Integer sid) {
        return promotionAdMapper.selectList(new QueryWrapper<PromotionAd>().lambda().eq(PromotionAd::getSpaceId,sid));
    }
}




