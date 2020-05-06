package com.java.wisdom.group.ishow.iuserprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author terry
 * 如果DAO层分离出来则该注释解除
 * @MapperScan(basePackages = {"com.java.wisdom.group.ishow.icore.mapper"})
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class IshowUserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(IshowUserProviderApplication.class, args);
    }

}
