package com.java.wisdom.group.ishow.iuserconsumer.service;

import com.java.wisdom.group.ishow.ientity.entity.TestInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "ishow-user-provider")
public interface TestInfoService {

    @RequestMapping(value = "/ishow-user-provider/test-info/test-info.html",method = RequestMethod.POST)
    ResponseEntity<TestInfo> getTestInfo(@RequestParam(value = "id") Integer id);
}
