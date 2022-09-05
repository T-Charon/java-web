package com.charon.edu_pay_service.controller;

import cn.hutool.core.util.IdUtil;
import com.alipay.api.AlipayApiException;
import com.charon.edu_pay_service.entity.Order;
import com.charon.edu_pay_service.service.AliPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Charon
 * @Date 2022/8/30
 **/

@RestController
@RequestMapping("alipay")
public class AliPayController {
    @Autowired
    private AliPayService aliPayService;
    /**
     * 支付宝支付 api
     *
     * @param
     * @param
     * @param
     * @param
     * @return
     * @throws AlipayApiException
     */
    @GetMapping("/order")
    public String alipay(String courseName, String price, @RequestParam(required = false)String courseDescription) throws AlipayApiException {
        Order order = new Order();
        String id = IdUtil.getSnowflakeNextIdStr();
        order.setOut_trade_no(id);
        order.setSubject(courseName);
        order.setTotal_amount(price);
        order.setDescription(courseDescription);
        System.out.println(order);
        return aliPayService.aliPay(order);
    }


}
