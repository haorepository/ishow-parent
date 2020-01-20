package com.java.wisdom.group.iuserconsumer.controller;

import com.java.wisdom.group.ishow.ientity.entity.TestInfo;
import com.java.wisdom.group.iuserconsumer.service.TestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：terry
 * @date ：Created in 2020/1/20 10:30
 */
@RestController
@RequestMapping(value = "/test-info")
public class TestInfoController {

    final TestInfoService testInfoService;

    @Autowired
    public TestInfoController(TestInfoService testInfoService){
        this.testInfoService = testInfoService;
    }

    @RequestMapping(value = "/test-info.html",method = RequestMethod.POST)
    public ResponseEntity<TestInfo> getTestInfo(@RequestParam(value = "id")Integer id){
        return testInfoService.getTestInfo(id);
    }
}
