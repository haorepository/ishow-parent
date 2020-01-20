package com.java.wisdom.group.ishow.iconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author terry
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class IshowConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(IshowConfigApplication.class, args);
    }

}
