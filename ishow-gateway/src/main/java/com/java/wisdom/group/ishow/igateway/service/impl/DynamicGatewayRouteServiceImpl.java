package com.java.wisdom.group.ishow.igateway.service.impl;

import com.java.wisdom.group.ishow.icommo.util.RedisUtil;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayAction;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayRoute;
import com.java.wisdom.group.ishow.igateway.common.Keys;
import com.java.wisdom.group.ishow.igateway.enums.ResultEnum;
import com.java.wisdom.group.ishow.igateway.repository.MysqlRoutesRepository;
import com.java.wisdom.group.ishow.igateway.service.DynamicGatewayRouteService;
import com.java.wisdom.group.ishow.igateway.service.GatewayActionService;
import com.java.wisdom.group.ishow.igateway.service.GatewayRouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author ：terry
 * @date ：Created in 2020/5/21 14:37
 * @description：TODO
 * @version: 1.0
 */
@Component
@SuppressWarnings(value = "all")
public class DynamicGatewayRouteServiceImpl implements DynamicGatewayRouteService, ApplicationEventPublisherAware {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(DynamicGatewayRouteServiceImpl.class);

    @Autowired
    private RedisUtil redis;

    @Autowired
    private GatewayRouteService routeService;

    @Autowired
    private GatewayActionService actionService;

    @Autowired
    private MysqlRoutesRepository routeRepository;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 获取路由列表
     * @author     ： terry
     * @date       ： Created in 2020/4/1 17:05
     * @param:
     * @return：
     */
    public Flux<RouteDefinition> getRouteList(){
        LOGGER.info("Get route list");
        return routeRepository.getRouteDefinitions();
    }

    /**
     * 增加路由
     * @author     ： terry
     * @date       ： Created in 2020/3/18 12:01
     * @param:  definition
     * @return：
     */
    public String add(GatewayRoute definition,RouteDefinition routeDefinition) {
        try {
            GatewayRoute route = routeService.selectByRouteId(definition);
            if(route!=null){
                return ResultEnum.FAIL.getValue();
            }else{
                boolean save = routeService.save(definition);
                if(save){
                    routeRepository.save(Mono.just(routeDefinition)).subscribe();
                    GatewayAction action = new GatewayAction();
                    action.setAction("添加路由"+definition.getRouteId());
                    action.setCreater(definition.getCreater());
                    action.setModifier(definition.getModifier());
                    actionService.save(action);
                    this.refreshApplicationEvent(ResultEnum.INSERT.getValue());
                    return ResultEnum.SUCCESS.getValue();
                }
            }
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return ResultEnum.FAIL.getValue();
    }
    /**
     * 更新路由
     * @author     ： terry
     * @date       ： Created in 2020/3/18 12:01
     * @param:  definition
     * @return：
     */
    public String update(GatewayRoute definition, RouteDefinition routeDefinition) {
        try {
            int update = routeService.customUpdateRoute(definition);
            if(update>0){
                routeRepository.save(Mono.just(routeDefinition)).subscribe();
                GatewayAction action = new GatewayAction();
                action.setAction("修改路由"+definition.getRouteId());
                action.setCreater(definition.getModifier());
                action.setModifier(definition.getModifier());
                actionService.save(action);
                this.refreshApplicationEvent(ResultEnum.UPDATE.getValue());
                return ResultEnum.SUCCESS.getValue();
            }
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return ResultEnum.FAIL.getValue();
    }
    /**
     * 删除路由
     * @author     ： terry
     * @date       ： Created in 2020/3/18 12:01
     * @param:
     * @return：
     */
    public String delete(String id,String userName) {
        try {
            int delete = routeService.deleteRoute(id);
            if(delete>0){
                GatewayAction action = new GatewayAction();
                action.setAction("删除路由"+id);
                action.setCreater(userName);
                action.setModifier(userName);
                actionService.save(action);
                this.refreshApplicationEvent(ResultEnum.DELETE.getValue());
                return ResultEnum.SUCCESS.getValue();
            }
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return ResultEnum.FAIL.getValue();
    }

    public void refreshApplicationEvent(String action){
        try {
            redisTemplate.convertAndSend(Keys.REDIS_TOPIC,action);
            applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
            LOGGER.info("Refresh route success");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Refresh route fail",e.getMessage());
        }
    }

    @Override
    public void refreshRoute() {
        System.out.println("===================== Action to do refresh route =====================");
        try {
            LOGGER.info("Begin initializing route to redis");
            MysqlRoutesRepository.ROUTE_MAP.clear();
            redis.del(Keys.GATEWAY_ROUTE_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Error initializing route to redis",e.getMessage());
        }finally {
            getRouteList();
            LOGGER.info("Initializing route to redis success");
        }
    }
}
