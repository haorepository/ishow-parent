package com.java.wisdom.group.ishow.igateway.repository;

import com.alibaba.fastjson.JSON;
import com.java.wisdom.group.ishow.icommo.util.RedisUtil;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayRoute;
import com.java.wisdom.group.ishow.igateway.common.Keys;
import com.java.wisdom.group.ishow.igateway.convert.RouteDefinitionConvert;
import com.java.wisdom.group.ishow.igateway.service.GatewayRouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：terry
 * @date ：Created in 2020/5/21 12:11
 * @description：TODO
 * @version: 1.0
 */
@Component
@SuppressWarnings(value = "all")
public class MysqlRoutesRepository implements RouteDefinitionRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(MysqlRoutesRepository.class);
    @Autowired
    private RedisUtil redis;
    @Autowired
    private GatewayRouteService routeService;

    public static final Map<String,Object> ROUTE_MAP = new ConcurrentHashMap<String,Object>();

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> routeDefinitionList = new ArrayList<RouteDefinition>();
        if(ROUTE_MAP.isEmpty()){
            LOGGER.info("Get routes from redis");
            List<RouteDefinition> routeList = new ArrayList<RouteDefinition>();
            //从redis读取路由表
            redis.hget(Keys.GATEWAY_ROUTE_KEY).stream().forEach(routeDefinition -> {
                routeList.add(JSON.parseObject(routeDefinition.toString(), RouteDefinition.class));
            });
            //redis有路由表则放入map
            if(routeList!=null && !routeList.isEmpty()){
                ROUTE_MAP.put(Keys.GATEWAY_ROUTE_KEY,routeList);
            }else{
                //redis没有路由表则从mysql读取
                LOGGER.info("Get routes from mysql");
                //读取路由表
                List<GatewayRoute> grList = routeService.selectAllRoute();
                if(grList!=null && !grList.isEmpty()){
                    //将数据库路由表转换成符合gateway的路由表
                    routeDefinitionList = RouteDefinitionConvert.grConvert2rd(grList);
                    //将数据库读出的路由表存入redis
                    routeDefinitionList.stream().forEach(route -> {
                        redis.hset(Keys.GATEWAY_ROUTE_KEY,route.getId(),JSON.toJSONString(route));
                    });
//                    //从redis读取路由表
//                    redis.hget(Keys.GATEWAY_ROUTE_KEY).stream().forEach(routeDefinition -> {
//                        routeList.add(JSON.parseObject(routeDefinition.toString(), RouteDefinition.class));
//                    });
                    //将路由表存入map
                    ROUTE_MAP.put(Keys.GATEWAY_ROUTE_KEY,routeDefinitionList);
                }
            }
        }
        //从map读取路由表
        if(!ROUTE_MAP.isEmpty()){
            LOGGER.info("Get routes from local map");
            routeDefinitionList = (List<RouteDefinition>)ROUTE_MAP.get(Keys.GATEWAY_ROUTE_KEY);
        }
        return Flux.fromIterable(routeDefinitionList);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap(routeDefinition -> {
            redis.hset(Keys.GATEWAY_ROUTE_KEY, routeDefinition.getId(),
                    JSON.toJSONString(routeDefinition));
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(id -> {
            if (redis.hHasKey(Keys.GATEWAY_ROUTE_KEY, id)) {
                redis.hdel(Keys.GATEWAY_ROUTE_KEY, id);
                return Mono.empty();
            }
            return Mono.defer(() -> Mono.error(new NotFoundException("路由文件没有找到: " + routeId)));
        });
    }
}
