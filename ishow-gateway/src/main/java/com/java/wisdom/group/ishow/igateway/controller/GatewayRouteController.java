package com.java.wisdom.group.ishow.igateway.controller;

import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayRoute;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayRouteDefinition;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayUser;
import com.java.wisdom.group.ishow.igateway.convert.RouteDefinitionConvert;
import com.java.wisdom.group.ishow.igateway.enums.ResultEnum;
import com.java.wisdom.group.ishow.igateway.service.GatewayUserService;
import com.java.wisdom.group.ishow.igateway.service.impl.DynamicGatewayRouteServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

/**
 * @author ：terry
 * @date ：Created in 2020/4/1 15:41
 * @description：TODO
 * @version: 1.0
 */
@RestController
@RequestMapping("/gateway")
@SuppressWarnings(value = "all")
public class GatewayRouteController {
    @Value("${spring.cloud.gateway.key}")
    private String gatewayKey;

    @Autowired
    private DynamicGatewayRouteServiceImpl routeService;

    @Autowired
    private GatewayUserService userService;

    /**
     * 添加路由
     * @author     ： terry
     * @date       ： Created in 2020/4/8 11:12
     * @param:
     * @return：
     */
    @PostMapping(value = "/route/add")
    public String add(@RequestBody GatewayRouteDefinition definition){
        if (verifyKey(definition.getGatewayKey())) {
            if(verifyUser(definition.getUserName())){
                GatewayRoute gatewayRoute = RouteDefinitionConvert.grdConvert2gr(definition);
                RouteDefinition routeDefinition = RouteDefinitionConvert.grdConvert2rd(definition);
                return routeService.add(gatewayRoute,routeDefinition);
            }
        }
        return ResultEnum.FAIL.getValue();
    }
    /**
     * 修改路由
     * @author     ： terry
     * @date       ： Created in 2020/4/8 11:12
     * @param:
     * @return：
     */
    @PostMapping(value = "/route/update")
    public String update(@RequestBody GatewayRouteDefinition definition){
        if (verifyKey(definition.getGatewayKey())) {
            if(verifyUser(definition.getUserName())){
                GatewayRoute gatewayRoute = RouteDefinitionConvert.grdConvert2gr(definition);
                RouteDefinition routeDefinition = RouteDefinitionConvert.grdConvert2rd(definition);
                return routeService.update(gatewayRoute,routeDefinition);
            }
        }
        return ResultEnum.FAIL.getValue();
    }
    /**
     * 删除路由
     * @author     ： terry
     * @date       ： Created in 2020/4/8 11:11
     * @param:
     * @return：
     */
    @GetMapping(value = "/route/delete/{userKey}/{routeId}/{userName}")
    public String delete(@PathVariable("userKey") String userKey, @PathVariable("routeId") String routeId, @PathVariable("userName") String userName){
        if (verifyKey(userKey)) {
            if(verifyUser(userName)){
                return routeService.delete(routeId,userName);
            }
        }
        return ResultEnum.FAIL.getValue();
    }

    /**
     * 获取路由列表
     * @author     ： terry
     * @date       ： Created in 2020/4/8 11:11
     * @param:
     * @return：
     */
    @GetMapping(value = "/route/get/{userKey}")
    public Flux<RouteDefinition> getRouteList(@PathVariable("userKey") String userKey){
        if (verifyKey(userKey)) {
            return routeService.getRouteList();
        }
        return Flux.fromIterable(new ArrayList<>());
    }

    /**
     * @author     ： 验证使用者
     * @date       ： Created in 2020/3/27 17:37
     * @param: userKey 认证用户的Key
     * @return：
     */
    private Boolean verifyKey(String userKey){
        if(!StringUtils.isEmpty(userKey)){
            return userKey.equals(gatewayKey);
        }
        return false;
    }

    /**
     * 验证是否存在用户
     * @author     ： terry
     * @date       ： Created in 2020/4/8 11:10
     * @param:
     * @return：
     */
    private Boolean verifyUser(String userName){
        GatewayUser user = userService.findByName(userName);
        return user != null;
    }
}
