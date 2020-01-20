package com.java.wisdom.group.ishow.ieureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author terry
 */
@SpringBootApplication
@EnableEurekaServer
public class IshowEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(IshowEurekaApplication.class, args);
    }

}
