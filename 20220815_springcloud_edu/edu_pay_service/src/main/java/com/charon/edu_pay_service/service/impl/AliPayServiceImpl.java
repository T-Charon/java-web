package com.charon.edu_pay_service.service.impl;

import com.alipay.api.AlipayApiException;
import com.charon.edu_pay_service.config.Alipay;
import com.charon.edu_pay_service.entity.Order;
import com.charon.edu_pay_service.service.AliPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Charon
 * @Date 2022/8/30
 **/
@Service
public class AliPayServiceImpl implements AliPayService {
    @Autowired
    private Alipay alipay;

    @Override
    public String aliPay(Order order) throws AlipayApiException {
        return alipay.pay(order);
    }
}
