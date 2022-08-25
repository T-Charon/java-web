package com.charon.comment.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author Charon
 * @Date 2022/8/18
 **/
public class GetHttpConnect {
    public void getHttp(String path) {
        try {
            //创建URL对象
            URL url = new URL(path);
            //打开连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置连接超时
            conn.setConnectTimeout(2000);
            //设置请求方法
            conn.setRequestMethod("GET");
            int code = conn.getResponseCode();
            if (200 == code) {
                //获取数据
                InputStream in = conn.getInputStream();
                int count = 0;
                while (count == 0) {
                    count = in.available();
                }
                //读取数据
                byte[] b = new byte[count];
                in.read(b);
                System.out.println(new String(b));
            } else {
                System.out.println("请求错误==>"+conn.getResponseCode());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
