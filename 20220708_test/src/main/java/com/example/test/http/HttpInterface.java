package com.example.test.http;


import sun.applet.Main;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @Author Charon
 * @Date 2022/8/5
 **/
public class HttpInterface {

    public  void testHttp(String path,String method,String arg){
        try {
            //创建URL对象
            URL url = new URL(path);
            //打开连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置请求方法
            conn.setRequestMethod(method);
            //设置连接超时
            conn.setConnectTimeout(2000);
            if(!"GET".equals(method)){
                //设置参数的类型
                conn.setRequestProperty("Content-type","application/x-www-form-urlencoded");
                //是否携带参数
                conn.setDoOutput(true);
                //携带参数
                OutputStream out = conn.getOutputStream();
                out.write(arg.getBytes("UTF-8"));
            }

            int code = conn.getResponseCode();
            if(200 == code){
                //获取数据
                InputStream in = conn.getInputStream();
                int count = 0;
                while (count == 0){
                    count = in.available();
                }
                //读取数据
                byte[] b = new byte[count];
                in.read(b);
                System.out.println(new String(b));


            }else {
                System.out.println("请求错误==>"+conn.getResponseCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new HttpInterface().testHttp("http://localhost:8080/employess","GET","");
        new HttpInterface().testHttp("http://localhost:8080/employess/1","DELETE","");
        new HttpInterface().testHttp("http://localhost:8080/employess","POST","name=zs&age=20&sex=女&address=湖南省&deptId=1");
        new HttpInterface().testHttp("http://localhost:8080/employess", "PUT", "id=3&name=111&age=20");

    }
}
