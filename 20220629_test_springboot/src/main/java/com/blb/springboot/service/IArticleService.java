package com.blb.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blb.springboot.entity.Article;
import com.blb.springboot.mapping.ArticleMapping;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/29
 **/

public interface IArticleService extends IService<Article> {
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
