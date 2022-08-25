package com.charon.edu_ad_service.controller;

import com.charon.comment.entity.PromotionAd;
import com.charon.edu_ad_service.service.PromotionAdService;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author Charon
 * @Date 2022/8/13
 **/

@RefreshScope
@RestController
@RequestMapping("/ad")
public class PromotionAdController {
    public static final String DIR = "http://192.168.75.245/";
    @Autowired
    private FastFileStorageClient client;


    @Autowired
    private PromotionAdService promotionAdService;

    @GetMapping("/list/{sid}")
    public ResponseEntity<List<PromotionAd>> getList(@PathVariable Integer sid){
        List<PromotionAd> list = promotionAdService.getList(sid);
        return ResponseEntity.ok(list);
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
