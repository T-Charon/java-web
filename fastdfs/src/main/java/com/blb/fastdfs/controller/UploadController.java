package com.blb.fastdfs.controller;


import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/6/30
 **/

@Api
@Controller
public class UploadController {

    public static final String DIR = "http://192.168.75.245/";

    @Autowired
    private FastFileStorageClient client;

    @ApiOperation("上传")
    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ResponseEntity<String> upload(MultipartFile file) throws IOException {
        //获得后缀名
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        //上传
        StorePath storePath = client.uploadFile(file.getInputStream(), file.getSize(), extension, null);
        System.out.println("save:" + storePath.getFullPath());
       return ResponseEntity.ok(DIR + storePath.getFullPath());

    }
}

