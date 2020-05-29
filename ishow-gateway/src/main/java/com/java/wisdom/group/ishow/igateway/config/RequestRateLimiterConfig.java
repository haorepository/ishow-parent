package com.java.wisdom.group.ishow.igateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/**
 * 网关限流
 * @author ：terry
 * @date ：Created in 2020/5/21 11:31
 * @description：TODO
 * @version: 1.0
 */
@Configuration
@SuppressWarnings(value = "all")
public class RequestRateLimiterConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestRateLimiterConfig.class);

    @Bean
    @Primary
    public KeyResolver apiKeyResolver() {
        //按URL限流,即以每秒内请求数按URL分组统计，超出限流的url请求都将返回429状态
        LOGGER.info("apiKeyResolver init");
        return exchange -> Mono.just(exchange.getRequest().getPath().toString());
    }

    @Bean
    public KeyResolver userKeyResolver() {
        //按用户限流
        LOGGER.info("userKeyResolver init");
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }

    @Bean
    public KeyResolver ipKeyResolver() {
        //按IP限流
        LOGGER.info("ipKeyResolver init");
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
