package com.java.wisdom.group.ishow.ientity.entity.gateway;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：terry
 * @date ：Created in 2020/3/31 15:12
 * @description：TODO
 * @version: 1.0
 */
@SuppressWarnings(value = "all")
@TableName(value = "t_gateway_route")
public class GatewayRoute implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String routeId;

    private String uri;

    private Integer orderNum;

    private String predicates;

    private String filters;

    //是否使用，1表示使用，0表示未使用
    //@TableField(fill= FieldFill.INSERT)
    private Integer enableNum;

    //自动填充注解
    @TableField(fill= FieldFill.INSERT)
    private String creater;

    //自动填充注解
    @TableField(fill=FieldFill.INSERT)
    private Date createTime;

    //自动填充注解
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private String modifier;

    //自动填充注解
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    //逻辑删除，1表示删除，0表示未删除
    @TableLogic
    @TableField(select=false)
    private Integer logicDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getPredicates() {
        return predicates;
    }

    public void setPredicates(String predicates) {
        this.predicates = predicates;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public Integer getEnableNum() {
        return enableNum;
    }

    public void setEnableNum(Integer enableNum) {
        this.enableNum = enableNum;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getLogicDelete() {
        return logicDelete;
    }

    public void setLogicDelete(Integer logicDelete) {
        this.logicDelete = logicDelete;
    }

    @Override
    public String toString() {
        return "GatewayRoute{" +
                "id='" + id + '\'' +
                ", routeId='" + routeId + '\'' +
                ", uri='" + uri + '\'' +
                ", orderNum=" + orderNum +
                ", predicates='" + predicates + '\'' +
                ", filters='" + filters + '\'' +
                ", enableNum=" + enableNum +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", modifier='" + modifier + '\'' +
                ", modifyTime=" + modifyTime +
                ", logicDelete=" + logicDelete +
                '}';
    }
}
