package com.blb.mysql_promotion_service.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blb.comment.entity.PromotionSpace;
import com.blb.mysql_promotion_service.service.PromotionSpaceService;
import com.blb.mysql_promotion_service.mapper.PromotionSpaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class PromotionSpaceServiceImpl extends ServiceImpl<PromotionSpaceMapper, PromotionSpace>
    implements PromotionSpaceService{

    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;
    @Override
    public IPage<PromotionSpace> getList(int current, int size) {
        return promotionSpaceMapper.getList(new Page(current,size));
    }
}




