package com.java.wisdom.group.ishow.igateway.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayFilterDefinition;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayPredicateDefinition;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayRoute;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayRouteDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：terry
 * @date ：Created in 2020/3/27 17:31
 * @description：TODO
 * @version: 1.0
 */
@SuppressWarnings(value = "all")
public class RouteDefinitionConvert {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(RouteDefinitionConvert.class);

    /**
     * GatewayRouteDefinition 转换成 RouteDefinition
     * @author     ： terry
     * @date       ： Created in 2020/4/1 11:36
     * @param:
     * @return：
     */
    public static RouteDefinition grdConvert2rd(GatewayRouteDefinition gatewaydefinition){
        RouteDefinition definition = new RouteDefinition();
        definition.setId(gatewaydefinition.getRouteId());
        definition.setOrder(gatewaydefinition.getOrder());

        //设置断言
        List<PredicateDefinition> pdList=new ArrayList<>();
        List<GatewayPredicateDefinition> gatewayPredicateDefinitionList=gatewaydefinition.getPredicates();
        for (GatewayPredicateDefinition gpDefinition: gatewayPredicateDefinitionList) {
            PredicateDefinition predicate = new PredicateDefinition();
            predicate.setArgs(gpDefinition.getArgs());
            predicate.setName(gpDefinition.getName());
            pdList.add(predicate);
        }
        definition.setPredicates(pdList);

        //设置过滤器
        List<FilterDefinition> filters = new ArrayList();
        List<GatewayFilterDefinition> gatewayFilters = gatewaydefinition.getFilters();
        for(GatewayFilterDefinition filterDefinition : gatewayFilters){
            FilterDefinition filter = new FilterDefinition();
            filter.setName(filterDefinition.getName());
            filter.setArgs(filterDefinition.getArgs());
            filters.add(filter);
        }
        definition.setFilters(filters);

        URI uri = null;
        if(gatewaydefinition.getUri().startsWith("http")){
            uri = UriComponentsBuilder.fromHttpUrl(gatewaydefinition.getUri()).build().toUri();
        }else{
            // uri为 lb://consumer-service 时使用下面的方法
            uri = URI.create(gatewaydefinition.getUri());
        }
        definition.setUri(uri);
        return definition;
    }

    /**
     * GatewayRouteDefinition 转换成 GatewayRoute
     * @author     ： terry
     * @date       ： Created in 2020/4/1 11:36
     * @param:
     * @return：
     */
    public static GatewayRoute grdConvert2gr(GatewayRouteDefinition gatewaydefinition){
        GatewayRoute gatewayRoute = new GatewayRoute();
        //RouteDefinition routeDefinition = routeDefinitionConvert(gatewaydefinition);
        String routeId = gatewaydefinition.getRouteId();
        String uri = gatewaydefinition.getUri();
        Integer order = gatewaydefinition.getOrder();
        List<GatewayPredicateDefinition> predicates = gatewaydefinition.getPredicates();
        List<GatewayFilterDefinition> filters = gatewaydefinition.getFilters();
        Integer enable = gatewaydefinition.getEnable();
        Integer delete = gatewaydefinition.getDelete();
        String userName = gatewaydefinition.getUserName();
        Integer action = gatewaydefinition.getAction();
        Gson gson = new Gson();
        String predicatesString = gson.toJson(predicates);
        String filtersString = gson.toJson(filters);
        gatewayRoute.setRouteId(routeId);
        gatewayRoute.setUri(uri);
        gatewayRoute.setOrderNum(order);
        gatewayRoute.setPredicates(predicatesString);
        gatewayRoute.setFilters(filtersString);
        gatewayRoute.setEnableNum(enable);
        gatewayRoute.setLogicDelete(delete);
        if(action==0){
            gatewayRoute.setCreater(userName);
            gatewayRoute.setModifier(userName);
        }
        if(action==1){
            gatewayRoute.setModifier(userName);
            gatewayRoute.setModifyTime(new Date());
        }
        return gatewayRoute;
    }

    /**
     * GatewayRoute 转换成 RouteDefinition
     * @author     ： terry
     * @date       ： Created in 2020/4/1 11:36
     * @param:
     * @return：
     */
    public static List<RouteDefinition> grConvert2rd(List<GatewayRoute> list){
        List<RouteDefinition> routeDefinitionList = new ArrayList<RouteDefinition>();
        Gson gson = new Gson();
        for(GatewayRoute route : list){
            try{
                RouteDefinition routeDefinition =  new RouteDefinition();
                String routeId = route.getRouteId();
                String uri =  route.getUri();
                Integer order = route.getOrderNum();
                String predicates = route.getPredicates();
                String filters = route.getFilters();
                routeDefinition.setId(routeId);
                routeDefinition.setOrder(order);
                List<GatewayPredicateDefinition> predicateList =
                        gson.fromJson(predicates, new TypeToken<List<GatewayPredicateDefinition>>() {
                        }.getType());
                List<GatewayFilterDefinition> filterList =
                        gson.fromJson(filters, new TypeToken<List<GatewayFilterDefinition>>() {
                        }.getType());
                if(predicateList!=null && predicateList.size()>0){
                    //设置断言
                    List<PredicateDefinition> pdList=new ArrayList<>();
                    for (GatewayPredicateDefinition gpDefinition: predicateList) {
                        PredicateDefinition predicate = new PredicateDefinition();
                        predicate.setArgs(gpDefinition.getArgs());
                        predicate.setName(gpDefinition.getName());
                        pdList.add(predicate);
                    }
                    routeDefinition.setPredicates(pdList);
                }
                if(filterList!=null && filterList.size()>0){
                    //设置过滤器
                    List<FilterDefinition> fdList = new ArrayList();
                    for(GatewayFilterDefinition filterDefinition : filterList){
                        FilterDefinition filter = new FilterDefinition();
                        filter.setName(filterDefinition.getName());
                        filter.setArgs(filterDefinition.getArgs());
                        fdList.add(filter);
                    }
                    routeDefinition.setFilters(fdList);
                }
                if(uri!=null){
                    URI url = null;
                    if(uri.startsWith("http")){
                        url = UriComponentsBuilder.fromHttpUrl(uri).build().toUri();
                    }else{
                        // uri为 lb://consumer-service 时使用下面的方法
                        url = URI.create(uri);
                    }
                    routeDefinition.setUri(url);
                }
                routeDefinitionList.add(routeDefinition);
            }catch (Exception e){
                LOGGER.error(e.getMessage());
                continue;
            }
        }
        return routeDefinitionList;
    }
}
