package com.java.wisdom.group.ishow.ientity.entity.gateway;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 过滤器模型
 * @author ：terry
 * @date ：Created in 2020/3/18 10:55
 * @description：TODO
 * @version: 1.0
 */
@SuppressWarnings(value = "all")
public class GatewayFilterDefinition {
    /**
     *Filter Name
     */
    private String name;
    /**
     *对应的路由规则
     */
    private Map<String, String> args = new LinkedHashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }
}
