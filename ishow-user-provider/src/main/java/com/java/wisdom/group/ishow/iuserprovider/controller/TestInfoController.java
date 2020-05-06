package com.java.wisdom.group.ishow.iuserprovider.controller;


import com.java.wisdom.group.ishow.ientity.entity.TestInfo;
import com.java.wisdom.group.ishow.iuserprovider.service.TestInfoCacheService;
import com.java.wisdom.group.ishow.iuserprovider.service.TestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 测试表 前端控制器
 * </p>
 *
 * @author terry
 * @since 2020-01-19
 */
@RestController
@RequestMapping(value = "/test-info")
public class TestInfoController {

    @Autowired
    private TestInfoService testInfoService;

    @Autowired
    private TestInfoCacheService testInfoCacheService;

    @RequestMapping(value = "/test-info.html",method = RequestMethod.POST)
    public ResponseEntity<TestInfo> getTestInfo(@RequestParam(value = "id") Integer id){
        TestInfo testInfo = testInfoService.getById(1);
        ResponseEntity<Boolean> responseEntity = testInfoCacheService.cacheTestInfo(testInfo);
        boolean flag = responseEntity.getBody();
        if(flag){
            return new ResponseEntity<TestInfo>(testInfo, HttpStatus.OK);
        }
        return null;
    }
}
