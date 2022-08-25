package ydzhao.weixin.tuisong.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ydzhao.weixin.tuisong.util.Pusher;

/**
 *@ClassName JobWorker
 *@Description TODO
 *@Author ydzhao
 *@Date 2022/8/2 16:00
 */
@Component
public class JobWorker {
    //要推送的用户openid
    @Value("${openID1}")
    private String openId;
    @Value("${openID2}")
    private String openId2;
    @Autowired Pusher pusher;

    @Scheduled(cron = "0 0 8 * * ?")
    public void goodMorning(){
        pusher.push(openId);
        pusher.push(openId2);
    }

    @Scheduled(cron = "0 0 9-21/1 * * ?")
    public void drink(){
        pusher.pushDrink(openId);
        pusher.pushDrink(openId2);
    }

}
