package com.java.wisdom.group.ishow.iuserprovider.service;

import com.java.wisdom.group.ishow.ientity.entity.TestInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ：terry
 * @date ：Created in 2020/4/30 15:15
 * @description：TODO
 * @version: 1.0
 */
@Component
@FeignClient(value = "ishow-cache",url = "http://admin:admin@192.168.0.73:7000")
public interface TestInfoCacheService {

    @RequestMapping(value = "/ishow-cache/test-info-cache/cache",method = RequestMethod.POST)
    ResponseEntity<Boolean> cacheTestInfo(@RequestBody TestInfo testInfo);
}
