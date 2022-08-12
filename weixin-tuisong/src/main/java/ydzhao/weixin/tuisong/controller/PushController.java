package ydzhao.weixin.tuisong.controller;

/**
 *@ClassName PushController
 *@Description TODO
 *@Author ydzhao
 *@Date 2022/8/2 15:48
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ydzhao.weixin.tuisong.util.Pusher;

@RestController
public class PushController {
    //要推送的用户openid
    @Value("${openID1}")
    private String openID1;
    @Value("${openID2}")
    private String openID2;
    @Autowired
    private Pusher pusher;

    /**
     * 微信测试账号推送
     *
     */
    @GetMapping("/push")
    public void push() {
        pusher.push(openID1);
    }

    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/LZY")
    public void push2() {
        pusher.push(openID2);
    }
    /**
     * 测试账号推送
     * */
    @GetMapping("/drink")
    public void pushdrink() {
        pusher.pushDrink(openID1);
        pusher.pushDrink(openID2);
    }


    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/{id}")
    public void pushId(@PathVariable("id") String id) {
        pusher.push(id);
    }
}