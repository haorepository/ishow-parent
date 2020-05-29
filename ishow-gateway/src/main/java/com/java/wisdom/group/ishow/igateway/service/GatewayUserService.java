package com.java.wisdom.group.ishow.igateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayUser;

/**
 * @author ：terry
 * @date ：Created in 2020/3/31 15:18
 * @description：TODO
 * @version: 1.0
 */
public interface GatewayUserService extends IService<GatewayUser> {
    /**
     * 按照名称查询人员
     * @author     ： terry
     * @date       ： Created in 2020/4/8 10:54
     * @param: name 名字
     * @return： GatewayUser
     */
    GatewayUser findByName(String name);
}
