package com.blb.day_20220625_springboot.utils;

/**
 * @Author Charon
 * @Date 2022/6/27
 **/


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class   ResposeResult<T> {
   private ResponseStatus status;

   private T data;

    /**
     * 正确返回数据
     */
    public static <T> ResposeResult<T> ok(T data){
        return new ResposeResult<T>(ResponseStatus.OK,data);
    }

    /**
     * 返回错误信息
     */
    public static  ResposeResult<String> error(ResponseStatus status){
        return new ResposeResult<>(status,status.getMessage());
    }

    /**
     *返回错误信息
     */
    public static  ResposeResult<String> error(ResponseStatus status,String err){
        return new ResposeResult<>(status,err);
    }

    /**
     * 将数据转换为json，发送给前端
     * @param resp
     * @param result
     */
    public static void write(HttpServletResponse resp, ResposeResult result) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");
        String msg = new ObjectMapper().writeValueAsString(result);
        PrintWriter writer = resp.getWriter();
        writer.write(msg);
        writer.close();
    }















}
