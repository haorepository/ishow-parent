package com.java.wisdom.group.ishow.igateway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.wisdom.group.ishow.ientity.entity.gateway.GatewayAction;
import com.java.wisdom.group.ishow.igateway.mapper.GatewayActionMapper;
import com.java.wisdom.group.ishow.igateway.service.GatewayActionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：terry
 * @date ：Created in 2020/4/2 12:11
 * @description：TODO
 * @version: 1.0
 */
@Service
@Transactional(readOnly = false)
public class GatewayActionServiceImpl extends ServiceImpl<GatewayActionMapper, GatewayAction> implements GatewayActionService {
}
