package com.java.wisdom.group.ishow.igateway.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayRoute;

import java.util.List;

/**
 * @author ：terry
 * @date ：Created in 2020/3/31 15:18
 * @description：TODO
 * @version: 1.0
 */
public interface GatewayRouteService extends IService<GatewayRoute> {

    List<GatewayRoute> selectAllRoute();

    int updateRoute(GatewayRoute route);

    int deleteRoute(String routeId);

    GatewayRoute selectByRouteId(GatewayRoute route);

    int customUpdateRoute(GatewayRoute route);
}
