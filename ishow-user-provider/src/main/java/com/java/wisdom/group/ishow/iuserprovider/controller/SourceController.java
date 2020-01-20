package com.java.wisdom.group.ishow.iuserprovider.controller;

import org.springframework.beans.factory.annotation.Value;
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
public class SourceController {

    @Value("${spring.profiles.active}")
    private String url;

    @RequestMapping(value = "/url.html")
    public String printUrl(){
        return url;
    }
}
