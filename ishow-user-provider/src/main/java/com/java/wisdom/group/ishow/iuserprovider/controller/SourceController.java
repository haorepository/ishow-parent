package com.java.wisdom.group.ishow.iuserprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：terry
 * @date ：Created in 2020/1/17 16:12
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */

@RestController
@RequestMapping(value = "/source")
@RefreshScope
public class SourceController {

    @Value("${spring.profiles.active}")
    private String url;

    @Value("${mytest.test}")
    private String mytest;

    @RequestMapping(value = "/url.html")
    public String printUrl(){
        return url;
    }

    @RequestMapping(value = "/mytest.html")
    public String printMytest(){
        return mytest;
    }
}
