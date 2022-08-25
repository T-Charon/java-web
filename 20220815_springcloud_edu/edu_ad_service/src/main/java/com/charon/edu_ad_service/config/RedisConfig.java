package com.charon.edu_ad_service.config;


import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.RedisSerializationContext;


/**
 * @author Charon
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisCacheConfiguration provideRedisCacheConfiguration(){
        //加载默认配置
        RedisCacheConfiguration conf = RedisCacheConfiguration.defaultCacheConfig();
        //返回Jackson序列化器
        return conf.serializeValuesWith(
                RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericFastJsonRedisSerializer()));
    }



}
