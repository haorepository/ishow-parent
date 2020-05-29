package com.java.wisdom.group.ishow.igateway.config;

import com.java.wisdom.group.ishow.igateway.service.DynamicGatewayRouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author ：terry
 * @date ：Created in 2020/5/21 14:35
 * @description：TODO
 * @version: 1.0
 */
@Component
@SuppressWarnings(value = "all")
public class RedisMessageSubscriber implements MessageListener {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(RedisMessageSubscriber.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DynamicGatewayRouteService routeService;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
        String msg = serializer.deserialize(message.getBody());
        System.out.println("============接收到的消息：" + msg+"==================");
        LOGGER.info("Come from redis message {} route",msg);
        routeService.refreshRoute();
    }
}
