package com.java.wisdom.group.ishow.icache;

import com.java.wisdom.group.ishow.icommo.config.RedisTemplateConfig;
import com.java.wisdom.group.ishow.icommo.util.RedisUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * @author ：terry
 * @date ：Created in 2020/4/27 11:24
 * @description：TODO
 * @version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@Import(value = {RedisTemplateConfig.class, RedisUtil.class})
public class IshowCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(IshowCacheApplication.class, args);
    }

}
