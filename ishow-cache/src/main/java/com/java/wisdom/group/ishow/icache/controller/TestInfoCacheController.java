package com.java.wisdom.group.ishow.icache.controller;

import com.java.wisdom.group.ishow.icache.servcie.TestInfoCacheService;
import com.java.wisdom.group.ishow.ientity.entity.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：terry
 * @date ：Created in 2020/4/30 14:53
 * @description：TODO
 * @version: 1.0
 */
@RefreshScope
@RestController
@RequestMapping(value = "/test-info-cache")
public class TestInfoCacheController {

    @Autowired
    private TestInfoCacheService cacheService;

    @Value("${spring.profiles.active}")
    private String active;

    @RequestMapping(value = "/cache",method = RequestMethod.POST)
    public ResponseEntity<Boolean> cacheTestInfo(@RequestBody TestInfo testInfo){
        boolean flag = cacheService.cacheUser(testInfo);
        return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
    }

    @RequestMapping(value = "/active",method = RequestMethod.GET)
    public ResponseEntity<String> cacheTestInfo(){
        return new ResponseEntity<String>(active,HttpStatus.OK);
    }
}
