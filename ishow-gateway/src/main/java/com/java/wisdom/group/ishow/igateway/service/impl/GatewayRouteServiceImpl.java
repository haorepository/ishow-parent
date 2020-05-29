package com.java.wisdom.group.ishow.igateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayRoute;
import com.java.wisdom.group.ishow.igateway.mapper.GatewayRouteMapper;
import com.java.wisdom.group.ishow.igateway.service.GatewayRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：terry
 * @date ：Created in 2020/3/31 15:14
 * @description：TODO
 * @version: 1.0
 */
@Service
@SuppressWarnings(value = "all")
public class GatewayRouteServiceImpl extends ServiceImpl<GatewayRouteMapper, GatewayRoute> implements GatewayRouteService {

    @Autowired
    private GatewayRouteMapper routeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<GatewayRoute> selectAllRoute() {
        QueryWrapper<GatewayRoute> queryWrapper = Wrappers.<GatewayRoute>query();
        queryWrapper.lambda()
                .eq(GatewayRoute::getEnableNum,1)
                .orderByAsc(GatewayRoute::getRouteId);
        return routeMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(readOnly = false)
    public int updateRoute(GatewayRoute route) {
        UpdateWrapper<GatewayRoute> updateWrapper = Wrappers.<GatewayRoute>update();
        updateWrapper.lambda().eq(GatewayRoute::getRouteId,route.getRouteId());
        return routeMapper.customUpdateRoute(route,updateWrapper);
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteRoute(String routeId) {
        QueryWrapper<GatewayRoute> queryWrapper = Wrappers.<GatewayRoute>query();
        queryWrapper.lambda().eq(GatewayRoute::getRouteId,routeId);
        return routeMapper.delete(queryWrapper);
    }

    @Override
    @Transactional(readOnly = true)
    public GatewayRoute selectByRouteId(GatewayRoute route) {
        QueryWrapper<GatewayRoute> queryWrapper = Wrappers.<GatewayRoute>query();
        queryWrapper.lambda().eq(GatewayRoute::getRouteId,route.getRouteId());
        return routeMapper.selectOne(queryWrapper);
    }

    @Override
    public int customUpdateRoute(GatewayRoute route) {
        LambdaUpdateWrapper<GatewayRoute> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.eq(GatewayRoute::getRouteId,route.getRouteId());
        return routeMapper.customUpdateRoute(route,updateWrapper);
    }


}
