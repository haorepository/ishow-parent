package com.java.wisdom.group.ishow.igateway;

import com.java.wisdom.group.ishow.icommo.config.RedisTemplateConfig;
import com.java.wisdom.group.ishow.icommo.util.RedisUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * @author terry
 */
@EnableDiscoveryClient
@SpringBootApplication
@Import(value = {RedisTemplateConfig.class, RedisUtil.class})
public class IshowGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(IshowGatewayApplication.class, args);
    }

}
