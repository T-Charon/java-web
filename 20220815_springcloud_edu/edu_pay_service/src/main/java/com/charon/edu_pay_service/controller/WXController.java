package com.charon.edu_pay_service.controller;

import com.charon.edu_pay_service.service.WXPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author Charon
 * @Date 2022/8/30
 **/
@Slf4j
@RestController
@RequestMapping("wxpay")
public class WXController {

    @Autowired
    private WXPayService payService;

    /**
     * 微信下单
     */
    @RequestMapping("/makeOrder")
    public Map<String,String> makeOrder( Long userId, Long courseId, Long activityId, Long price) throws Exception {
        //微信下单
        return payService.makeWxOrder(userId,courseId, activityId, price);
    }

    /**
     * 生成支付二维码
     * @param url
     * @param response
     */
    @RequestMapping("code")
    public void createWxPayCode(String url, HttpServletResponse response){
        //创建支付二维码
        payService.makeQRCode(url,response);
        log.info("生成微信支付二维码：{}",url);
    }

    /**
     * 微信支付平台支付成功的回调
     */
    @RequestMapping("callback")
    public void paySuccessCallback(HttpServletRequest request, HttpServletResponse response) {
        try {
            payService.wxpayCallback(request,response);
        } catch (Exception e) {
            log.error("微信回调异常",e);
        }
    }

    /**
     * 检查订单状态
     */
    @RequestMapping("checkOrder")
    public String checkOrder(String tradeNo) throws Exception {
        if (!StringUtils.hasText(tradeNo)) {
            return null;
        }
        String status = payService.checkWxOrder(tradeNo);
        log.info("检查订单{} 状态：{}",tradeNo,status);
        return status;
    }
}
