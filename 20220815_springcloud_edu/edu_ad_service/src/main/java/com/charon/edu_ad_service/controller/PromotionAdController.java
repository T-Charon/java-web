package com.charon.edu_ad_service.controller;

import com.charon.comment.entity.PromotionAd;
import com.charon.edu_ad_service.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/8/13
 **/

@RefreshScope
@RestController
@RequestMapping("/ad")
public class PromotionAdController {




    @Autowired
    private PromotionAdService promotionAdService;

    @GetMapping("/list/{sid}")
    public ResponseEntity<List<PromotionAd>> getList(@PathVariable Integer sid){
        List<PromotionAd> list = promotionAdService.getList(sid);
        return ResponseEntity.ok(list);
    }



}
