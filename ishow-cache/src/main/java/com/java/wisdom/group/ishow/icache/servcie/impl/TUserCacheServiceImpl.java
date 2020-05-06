package com.java.wisdom.group.ishow.icache.servcie.impl;

import com.java.wisdom.group.ishow.icache.servcie.TUserCacheService;
import com.java.wisdom.group.ishow.icommo.util.RedisUtil;
import com.java.wisdom.group.ishow.ientity.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：terry
 * @date ：Created in 2020/4/30 9:43
 * @description：TODO
 * @version: 1.0
 */
@Service
@SuppressWarnings(value = "all")
public class TUserCacheServiceImpl implements TUserCacheService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public TUser getUserByCache() {
        return (TUser) redisUtil.get("user");
    }

    @Override
    public boolean cacheUser(TUser user) {
       boolean flag = redisUtil.set(user.getUserId(),user);
       if(flag){
           System.out.println("添加用户缓存成功");
       }
       return flag;
    }
}
