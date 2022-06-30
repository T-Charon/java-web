package com.blb.springboot.mapping;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blb.springboot.entity.Article;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/29
 **/


public interface ArticleMapping extends BaseMapper<Article> {
    /**
     * 获取所有文章信息
     * @return
     */
    List<Article> getAll();

    /**
     * 根据标题或内容模糊查询
     * @param article
     * @return
     */
    List<Article> getByTitleOrContent(Article article);
}
