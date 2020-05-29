package com.java.wisdom.group.ishow.igateway.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayRoute;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：terry
 * @date ：Created in 2020/3/31 15:10
 * @description：TODO
 * @version: 1.0
 */
@Mapper
public interface GatewayRouteMapper extends BaseMapper<GatewayRoute> {
    /**
     * 自定义网关修改方法
     * @author     ： terry
     * @date       ： Created in 2020/4/8 18:00
     * @param:
     * @return：
     */
    int customUpdateRoute(@Param("route") GatewayRoute route, @Param(Constants.WRAPPER) Wrapper wrapper);
}
