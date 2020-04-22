package com.java.wisdom.group.ishow.iuserconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author     ： terry
 * @date       ： Created in 2020/1/19 17:58
 * @param:
 * @return：
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class IshowUserConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IshowUserConsumerApplication.class, args);
    }

}


