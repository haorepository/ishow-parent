package com.java.wisdom.group.ishow.icache.servcie.impl;

import com.java.wisdom.group.ishow.icache.servcie.TestInfoCacheService;
import com.java.wisdom.group.ishow.icommo.util.RedisUtil;
import com.java.wisdom.group.ishow.ientity.entity.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：terry
 * @date ：Created in 2020/4/30 12:18
 * @description：TODO
 * @version: 1.0
 */
@Service
@SuppressWarnings(value = "all")
public class TestInfoCacheServiceImpl implements TestInfoCacheService {

    @Autowired
    private RedisUtil redisUtil;
    public TestInfoCacheServiceImpl(RedisUtil redisUtil){
        this.redisUtil = redisUtil;
    }

    @Override
    public TestInfo getUserByCache() {
        return (TestInfo)redisUtil.get("user");
    }

    @Override
    public boolean cacheUser(TestInfo user) {
        return redisUtil.set("user",user);
    }
}
