package com.java.wisdom.group.ishow.igateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author terry
 */
@EnableDiscoveryClient
@SpringBootApplication
public class IshowGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(IshowGatewayApplication.class, args);
    }

}
