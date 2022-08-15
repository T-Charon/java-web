package com.blb.mysql_promotion_service.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.comment.entity.PromotionAd;
import com.blb.mysql_promotion_service.service.PromotionAdService;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @Author Charon
 * @Date 2022/8/13
 **/

@RefreshScope
@RestController
public class PromotionAdController {
    public static final String DIR = "http://192.168.75.245/";
    @Autowired
    private FastFileStorageClient client;
    @Autowired
    private PromotionAdService promotionAdService;

    @GetMapping("/promotionadlist/{current}/{size}")
    public ResponseEntity<IPage<PromotionAd>> getList(@PathVariable int current, @PathVariable int size){
        return ResponseEntity.ok( promotionAdService.getList(current,size));
    }

    @GetMapping("/promotionad/{id}")
    public ResponseEntity< PromotionAd> getPromotionAdById(@PathVariable Long id){
        return ResponseEntity.ok(promotionAdService.getById(id));
    }

    @PostMapping("/promotionad")
    public ResponseEntity<String> addPromotionAd(PromotionAd promotionAd){
        promotionAd.setCreateTime(LocalDateTime.now());
        promotionAdService.save(promotionAd);
        return ResponseEntity.ok("ok");
    }

    @PutMapping("/promotionad")
    public ResponseEntity<String> updatePromotionAd(@RequestBody PromotionAd promotionAd){
        promotionAd.setUpdateTime(LocalDateTime.now());
        promotionAdService.updateById(promotionAd);
        return ResponseEntity.ok("ok");
    }
    @DeleteMapping("/promotionad/{id}")
    public ResponseEntity<String> deletePromotionAd(@PathVariable Long id){
        promotionAdService.removeById(id);
        return ResponseEntity.ok("ok");
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> upload(MultipartFile file) throws IOException {
        //获得后缀名
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        //上传
        StorePath storePath = client.uploadFile(file.getInputStream(), file.getSize(), extension, null);
        System.out.println("save:" + storePath.getFullPath());
        return ResponseEntity.ok(DIR + storePath.getFullPath());
    }
}
