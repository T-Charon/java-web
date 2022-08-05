package com.blb.download;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @Author Charon
 * @Date 2022/8/5
 *
 **/
public class DownLoadDemo {
    public static void download(String path){

        try {
            //创建URL对象
            URL url = new URL(path);
            //打开连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置连接超时
            conn.setConnectTimeout(5000);
            //设置请求方法
            conn.setRequestMethod("GET");
           //设置下载后的文件名
            String fileName = UUID.randomUUID().toString().replace("-", "")+".jpg";


            InputStream in = conn.getInputStream();
            System.out.println("文件下载完成");
            Files.copy(in, Paths.get("C:\\file\\" + fileName));
            Runtime.getRuntime().exec("mspaint " +"C:\\file\\" + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        download("https://tupian.qqw21.com/article/UploadPic/2020-4/202042720415719157.jpg");
    }
}
