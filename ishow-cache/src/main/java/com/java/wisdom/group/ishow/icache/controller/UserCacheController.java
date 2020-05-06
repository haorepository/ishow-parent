package com.java.wisdom.group.ishow.icache.controller;

import com.java.wisdom.group.ishow.icache.servcie.TUserCacheService;
import com.java.wisdom.group.ishow.ientity.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：terry
 * @date ：Created in 2020/4/30 9:37
 * @description：TODO
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "/user-cache")
public class UserCacheController {

    @Autowired
    private TUserCacheService userCacheService;

    @RequestMapping(value = "/get/user")
    public ResponseEntity<TUser> getUserCache(){
        TUser user = userCacheService.getUserByCache();
        return new ResponseEntity<TUser>(user,HttpStatus.OK);
    }

    @RequestMapping(value = "/cache/user")
    public ResponseEntity<Boolean> cacheUser(){
        boolean flag = userCacheService.cacheUser(new TUser());
        return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
    }
}
