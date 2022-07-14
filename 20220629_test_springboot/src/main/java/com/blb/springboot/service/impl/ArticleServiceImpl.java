package com.blb.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blb.springboot.entity.Article;
import com.blb.springboot.mapping.ArticleMapping;
import com.blb.springboot.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/29
 **/

@CacheConfig(cacheNames = "articles")
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapping, Article> implements IArticleService {
    @Autowired
    private ArticleMapping articleMapping;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Cacheable(cacheNames = "articles" ,key = "T(String).valueOf(100)")
    @Override
    public List<Article> getAll() {
        return articleMapping.getAll();
    }

    @Override
    public List<Article> getByTitleOrContent(Article article) {
        return articleMapping.getByTitleOrContent(article);
    }

    @Override
    public Article addArticle(Article article) {
        return null;
    }

    @Override
    public Article updateArticle(Article article) {
        return null;
    }

    @Override
    public void deleteArticle(Long articleId) {

    }
}
