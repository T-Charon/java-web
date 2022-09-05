package com.charon.edu_pay_service.service;

import com.alipay.api.AlipayApiException;
import com.charon.edu_pay_service.entity.Order;

/**
 * @Author Charon
 * @Date 2022/8/30
 * 支付 service
 **/
public interface AliPayService {
    /**
     * 支付宝支付接口
     * @param order
     * @return
     * @throws AlipayApiException
     */
    String aliPay(Order order) throws AlipayApiException;
}
