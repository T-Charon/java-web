package com.blb.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blb.springboot.entity.Article;
import com.blb.springboot.mapping.ArticleMapping;
import com.blb.springboot.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/29
 **/

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapping, Article> implements IArticleService {
    @Autowired
    private ArticleMapping articleMapping;

    @Override
    public List<Article> getAll() {
        return articleMapping.getAll();
    }

    @Override
    public List<Article> getByTitleOrContent(Article article) {
        return articleMapping.getByTitleOrContent(article);
    }
}
