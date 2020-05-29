package com.java.wisdom.group.ishow.igateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayUser;
import com.java.wisdom.group.ishow.igateway.mapper.GatewayUserMapper;
import com.java.wisdom.group.ishow.igateway.service.GatewayUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：terry
 * @date ：Created in 2020/4/2 12:11
 * @description：TODO
 * @version: 1.0
 */
@Service
@SuppressWarnings(value = "all")
public class GatewayUserServiceImpl extends ServiceImpl<GatewayUserMapper, GatewayUser> implements GatewayUserService {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(GatewayUserServiceImpl.class);
    @Autowired
    private GatewayUserMapper userMapper;

    @Override
    @Transactional(readOnly = false)
    public GatewayUser findByName(String name) {
        GatewayUser user = new GatewayUser();
        try {
            LambdaQueryWrapper<GatewayUser> queryWrapper = Wrappers.lambdaQuery();
            queryWrapper.eq(GatewayUser::getName,name);
            user = userMapper.selectOne(queryWrapper);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }
        return user;
    }
}
