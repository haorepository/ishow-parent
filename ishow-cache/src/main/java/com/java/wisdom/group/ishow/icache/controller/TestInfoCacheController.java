package com.java.wisdom.group.ishow.icache.controller;

import com.java.wisdom.group.ishow.icache.servcie.TestInfoCacheService;
import com.java.wisdom.group.ishow.ientity.entity.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping(value = "/test-info-cache")
public class TestInfoCacheController {

    @Autowired
    private TestInfoCacheService cacheService;

    @RequestMapping(value = "/cache",method = RequestMethod.POST)
    public ResponseEntity<Boolean> cacheTestInfo(@RequestBody TestInfo testInfo){
        boolean flag = cacheService.cacheUser(testInfo);
        return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
    }
}
