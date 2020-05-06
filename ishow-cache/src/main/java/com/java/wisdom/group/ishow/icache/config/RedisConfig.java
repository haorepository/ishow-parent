package com.java.wisdom.group.ishow.icache.config;

import com.java.wisdom.group.ishow.icommo.config.RedisTemplateConfig;
import com.java.wisdom.group.ishow.icommo.util.RedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * @author ：terry
 * @date ：Created in 2020/1/20 15:38
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */
@Configuration
public class RedisConfig {

    //@Bean
    //public RedisTemplateConfig redisTemplateConfig(){
    //    return new RedisTemplateConfig();
    //}

    @Bean
    public RedisUtil redisUtil(){
        return new RedisUtil();
    }
}
