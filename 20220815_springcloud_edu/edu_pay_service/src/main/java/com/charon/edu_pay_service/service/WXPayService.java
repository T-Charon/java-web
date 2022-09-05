package com.charon.edu_pay_service.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author Charon
 * @Date 2022/8/30
 **/

public interface WXPayService {




    /**
     * 下单
     */
    Map<String, String> makeWxOrder(long userId,long courseId,long activityId,long price) throws Exception;
    /**
     * 生成二维码
     *
     * @param url
     * @param response
     */
   void makeQRCode(String url, HttpServletResponse response) ;

    /**
     * 检查订单状态
     */
    String checkWxOrder(String tradeNo) throws Exception;

    /**
     * 微信支付回调
     * @param request
     * @param response
     * @throws Exception
     */
   void wxpayCallback(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * 关闭微信订单
     */
   void doOrderClose(String tradeNo) throws Exception;
}
