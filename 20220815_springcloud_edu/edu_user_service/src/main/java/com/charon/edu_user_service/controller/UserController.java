package com.charon.edu_user_service.controller;

import com.charon.comment.util.JwtUtil;
import com.charon.comment.util.RsaUtil;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/8/29
 **/
@RestController
@RequestMapping("/user")
public class UserController {


    public static final String DIR = "http://192.168.75.245/";

    @Autowired
    private  FastFileStorageClient client;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(MultipartFile file) throws IOException {
        //获得后缀名
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        //上传
        StorePath storePath = client.uploadFile(file.getInputStream(), file.getSize(), extension, null);
        System.out.println("save:" + storePath.getFullPath());
        return ResponseEntity.ok(DIR + storePath.getFullPath());
    }

    @GetMapping("/refresh-token")
    public String refreshToken(HttpServletRequest request){
        //获得请求头中Authorization token信息
        String authorization = request.getHeader("Authorization");
        String username = JwtUtil.getUsernameFromToken(authorization, RsaUtil.publicKey);
        String s = JwtUtil.generateToken(username, RsaUtil.privateKey, JwtUtil.EXPIRE_MINUTES);
        return s;
    }



}
