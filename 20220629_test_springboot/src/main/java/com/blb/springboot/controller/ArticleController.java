package com.blb.springboot.controller;

import com.blb.springboot.entity.Article;
import com.blb.springboot.service.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/29
 **/

@Api
@CrossOrigin
@RestController
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    /**
     * 查询所有文章
     * @return
     */
    @ApiOperation("查询所有文章")
    @GetMapping("articleList")
    public ResponseEntity<List<Article>> seleteAll(){
        List<Article> articleList = articleService.getAll();
        System.out.println("文章列表为："+articleList);
        return ResponseEntity.ok(articleList);
    }

    /**
     * 模糊查询
     * @param article
     * @return
     */
    @GetMapping("articles")
    public ResponseEntity<List<Article>> seleteArticle(Article article){
        List<Article> articles = articleService.getByTitleOrContent(article);
        return ResponseEntity.ok(articles);
    }


    @ApiOperation("增加文章")
    @PostMapping("article")
    public ResponseEntity<String> add(Article article){
        articleService.save(article);
        return ResponseEntity.ok("ok");
    }


    @ApiOperation("更新文章")
    @PutMapping("article")
    public ResponseEntity<String> update(@RequestBody Article article){
        articleService.updateById(article);
        return ResponseEntity.ok("ok");
    }


    @ApiOperation("删除文章")
    @DeleteMapping("article/{articleId}")
    public ResponseEntity<String> delete(@PathVariable Long articleId){
        System.out.println(articleId);
        articleService.removeById(articleId);
        return ResponseEntity.ok("ok");
    }


}
