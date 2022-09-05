package com.charon.edu_pay_service.service.impl;

import cn.hutool.core.util.IdUtil;
import com.charon.comment.entity.UserCourseOrder;
import com.charon.edu_pay_service.config.MyWXPayConfig;
import com.charon.edu_pay_service.config.RabbitConfig;
import com.charon.edu_pay_service.feign.CourseActivityClient;
import com.charon.edu_pay_service.feign.OrderClient;
import com.charon.edu_pay_service.service.WXPayService;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Charon
 * @Date 2022/8/30
 **/
@Slf4j
@Service
public class WXPayServiceImpl  implements WXPayService {
    @Autowired
    private CourseActivityClient courseActivityClient;

    @Autowired
    private OrderClient orderClient;

    @Autowired(required = false)
    private RabbitTemplate rabbitTemplate;




    public static final String DEVICE_INFO = "WEB";
    public static final String BODY = "泡泡教育";
    public static final String FEE_TYPE = "CNY";

    //回调接口的URL
    public static final String NOTIFY_URL = "https://41b67dbf.cpolar.io/wxpay/callback";
    public static final String TRADE_TYPE = "NATIVE";
    public static final String SIGN = "5E00F9F72173C9449F802411E36208734B8138870ED3F66D8E2821D55B317078";

    /**
     * 下单
     */
    @GlobalTransactional(rollbackFor = {Exception.class})
    @Override
    public Map<String, String> makeWxOrder(long userId, long courseId, long activityId, long price) throws Exception {
        //创建支付对象
        MyWXPayConfig config = new MyWXPayConfig();
        WXPay wxPay = new WXPay(config);
        //配置微信支付
        Map<String, String> map = new HashMap<>();
        map.put("appid", config.getAppID());
        map.put("mch_id", config.getMchID());
        map.put("device_info", DEVICE_INFO);
        map.put("nonce_str", WXPayUtil.generateNonceStr());
        map.put("body", BODY);
        //创建随机订单号

        String tradeNo =  IdUtil.getSnowflakeNextIdStr();
        map.put("out_trade_no", tradeNo);
        map.put("fee_type", FEE_TYPE);
        //价格
        map.put("total_fee", String.valueOf(price));
        //微信对商户后台的回调接口，更新订单状态
        map.put("notify_url", NOTIFY_URL);
        map.put("trade_type", TRADE_TYPE);
        map.put("product_id", String.valueOf(courseId));

        //执行统一下单
        Map<String, String> result = wxPay.unifiedOrder(map);
        //保存订单号
        result.put("trade_no", tradeNo);


        //判断库存(库存不为0时返回true)
        Boolean b = courseActivityClient.changeStock(activityId, -1).getBody();
        if(b){
            //有库存则添加订单
            Boolean o = orderClient.savaOrder(new UserCourseOrder(Long.valueOf(tradeNo), userId, courseId, activityId, (byte) 0, null, null, null, tradeNo, 1, price)).getBody();
            if(b && o){
                log.info("下单成功:{}" ,result);
                //发送消息，超时会进入死信队列
                rabbitTemplate.convertAndSend(RabbitConfig.ORDER_EXCHANGE, RabbitConfig.ORDER_QUEUE_KEY, tradeNo,
                        //消息的后置处理
                        message -> {
                            message.getMessageProperties().setMessageId(tradeNo);
                            //消息超时
                            message.getMessageProperties().setExpiration(String.valueOf(40 * 1000));
                            return message;
                        });
                //创建课程订单
                return result;
            }
        }
        log.info("下单失败:{}" );
        //下单失败返回null
        return null;

    }

    /**
     * 生成二维码
     *
     * @param url
     * @param response
     */
    @Override
    public void makeQRCode(String url, HttpServletResponse response) {
        //通过支付链接生成二维码
        HashMap<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);
        try {
            //把code_url包装到二维码图片
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 200, 200, hints);
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", response.getOutputStream());
            log.info("创建二维码完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 检查订单状态
     */
    @Override
    public String checkWxOrder(String tradeNo) throws Exception {
        MyWXPayConfig config = new MyWXPayConfig();
        WXPay pay = new WXPay(config);
        Map<String, String> map = new HashMap<>();
        map.put("appid",config.getAppID());
        map.put("mch_id", config.getMchID());
        map.put("nonce_str", WXPayUtil.generateNonceStr());
        map.put("out_trade_no", tradeNo);
        map.put("sign",SIGN);
        //查询订单
        Map<String, String> res = pay.orderQuery(map);
        String state = res.get("trade_state");
        log.info("订单" + tradeNo + ",状态" + state);
        return state;
    }

    /**
     * 微信支付成功回调
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    public void wxpayCallback(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获得微信传来的xml字符串
        String str = Streams.asString(request.getInputStream());
        //将字符串xml转换为Map
        Map<String, String> map = WXPayUtil.xmlToMap(str);
        //给微信发送消息
        response.getWriter().println("<xml>\n" +
                "<return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "<return_msg><![CDATA[OK]]></return_msg>\n" +
                "</xml>");
        //读取订单号
        String tradeNo = map.get("out_trade_no");
        //读取商品编号
        String id = map.get("product_id");
        //根据订单编号查询活动表获取课程ID
        UserCourseOrder course = orderClient.getById(Long.valueOf(tradeNo)).getBody();
        //修改订单状态为已支付
        Boolean b = orderClient.updateOrder(Long.valueOf(tradeNo), (byte) 1).getBody();
        //增加销量
        Boolean c = courseActivityClient.updateSales(course.getCourseId(), 1).getBody();
        log.info("更新订单状态成功===>",b);
        log.info("更新销量成功===>",c);
        log.info("支付成功===>",tradeNo);
    }

    @Override
    public void doOrderClose(String tradeNo) throws Exception{
        WXPay wxPay = new WXPay(new MyWXPayConfig());
        HashMap<String, String> map = new HashMap<>();
        map.put("out_trade_no", tradeNo);
        wxPay.closeOrder(map);

    }

}
