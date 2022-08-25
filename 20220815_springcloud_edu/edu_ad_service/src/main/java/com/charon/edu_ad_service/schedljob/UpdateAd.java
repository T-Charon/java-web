package com.charon.edu_ad_service.schedljob;

import com.charon.comment.util.GetHttpConnect;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author Charon
 * @Date 2022/8/18
 **/
@EnableScheduling
@Configuration
public class UpdateAd {
    //开启定时任务，查询数据库
    @Scheduled(cron = "0 */30 * * * ?")
    public void getAd(){
        new GetHttpConnect().getHttp("http://192.168.75.245:81/ad_update?sid=1");
    }


}
