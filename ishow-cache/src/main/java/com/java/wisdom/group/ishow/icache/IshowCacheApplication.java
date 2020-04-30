package com.java.wisdom.group.ishow.icache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：terry
 * @date ：Created in 2020/4/27 11:24
 * @description：TODO
 * @version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class IshowCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(IshowCacheApplication.class, args);
    }

}
