package com.blb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.UUID;

/**
 * @Author Charon
 * @Date 2022/6/11
 **/

@Controller
public class UploadController {
    @ResponseBody
    @PostMapping("upload")
    public String  upload(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();

        //随机生成UUID(当做前缀)，将可能出现的-换成空格
        String prefix = UUID.randomUUID().toString().replaceAll("-", "");

        //文件名后缀（.xxx）
        String suffix = filename.substring(filename.lastIndexOf("."));
        filename = prefix + suffix;

        //将图片写回内存中
        File newFile = new File("d:/upload/" + filename);
        file.transferTo(newFile);
        System.out.println(filename);

        //返回文件名到文件下载功能的回调函数e中
        return filename;
    }

    @GetMapping("show/{img}")
    public void show(@PathVariable("img") String img, HttpServletResponse response) throws IOException {
        System.out.println("show");
        System.out.println(img);
        File file = new File("d:/upload/" + img);
        //将所有字节从文件复制到输出流
        Files.copy(file.toPath(),response.getOutputStream());

    }
//    @GetMapping("upload/{img}")
//    public void upload(@PathVariable("img") String img, HttpServletResponse response) throws IOException {
//        System.out.println("show");
//        System.out.println(img);
//        File file = new File("d:/upload/" + img);
//        //设置为下载文件
//        response.setContentType("application/x-msdownload");
//        //设置文件名字
//        response.setHeader("Content-Disposition","attachment;filename="+
//                URLEncoder.encode("name","UTF8"));
//        //设置进度条
//        response.setContentLengthLong(file.length());
//        //将所有字节从文件复制到输出流
//        Files.copy(file.toPath(),response.getOutputStream());
//
//    }
}
