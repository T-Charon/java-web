package com.blb.springboot;

import com.blb.springboot.entity.Article;
import com.blb.springboot.service.IArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private IArticleService articleService;

    @Test
    void contextLoads() {
        List<Article> all = articleService.getAll();
        System.out.println(all);

    }

}
