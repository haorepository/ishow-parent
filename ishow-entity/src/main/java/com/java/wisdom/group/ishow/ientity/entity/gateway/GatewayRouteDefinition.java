package com.java.wisdom.group.ishow.ientity.entity.gateway;

import java.util.ArrayList;
import java.util.List;

/**
 * 路由模型
 * @author ：terry
 * @date ：Created in 2020/3/18 10:54
 * @description：TODO
 * @version: 1.0
 */
@SuppressWarnings(value = "all")
public class GatewayRouteDefinition {
    /**
     * 路由ID
     * @author     ： terry
     * @date       ： Created in 2020/3/18 11:02
     * @param:
     * @return：
     */
    private String routeId;
    /**
     * 进行路由操作时的key
     * @author     ： terry
     * @date       ： Created in 2020/3/18 12:45
     * @param:
     * @return：
     */
    private String gatewayKey;
    /**
     * 路由规则转发的目标uri
     * @author     ： terry
     * @date       ： Created in 2020/3/18 11:03
     * @param:
     * @return：
     */
    private String uri;
    /**
     * 路由执行的顺序
     * @author     ： terry
     * @date       ： Created in 2020/3/18 11:03
     * @param:
     * @return：
     */
    private Integer order = 0;
    /**
     * 路由断言集合配置
     * @author     ： terry
     * @date       ： Created in 2020/3/18 11:02
     * @param:
     * @return：
     */
    private List<GatewayPredicateDefinition> predicates = new ArrayList<>();
    /**
     *路由过滤器集合配置
     *  @author     ： terry
     * @date       ： Created in 2020/3/18 11:03
     * @param:
     * @return：
     */
    private List<GatewayFilterDefinition> filters = new ArrayList<>();

    /**
     * 是否启用，0启用，1：未启用
     * @author     ： terry
     * @date       ： Created in 2020/4/1 11:08
     * @param:
     * @return：
     */
    private Integer enable;

    /**
     * 是否删除，0：未删除，1：已删除
     * @author     ： terry
     * @date       ： Created in 2020/4/1 11:08
     * @param:
     * @return：
     */
    private Integer delete;

    /**
     * 操作人
     * @author     ： terry
     * @date       ： Created in 2020/4/1 11:25
     * @param:
     * @return：
     */
    private String userName;

    /**
     * 添加或是删除，0：添加，1：删除,修改
     * @author     ： terry
     * @date       ： Created in 2020/4/1 11:25
     * @param:
     * @return：
     */
    private Integer action;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getGatewayKey() {
        return gatewayKey;
    }

    public void setGatewayKey(String gatewayKey) {
        this.gatewayKey = gatewayKey;
    }

    public List<GatewayPredicateDefinition> getPredicates() {
        return predicates;
    }

    public void setPredicates(List<GatewayPredicateDefinition> predicates) {
        this.predicates = predicates;
    }

    public List<GatewayFilterDefinition> getFilters() {
        return filters;
    }

    public void setFilters(List<GatewayFilterDefinition> filters) {
        this.filters = filters;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }
}
