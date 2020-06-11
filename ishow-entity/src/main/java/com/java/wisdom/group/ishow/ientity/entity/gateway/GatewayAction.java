package com.java.wisdom.group.ishow.ientity.entity.gateway;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：terry
 * @date ：Created in 2020/4/2 12:02
 * @description：TODO
 * @version: 1.0
 */
@SuppressWarnings(value = "all")
@TableName(value = "t_gateway_action")
public class GatewayAction implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    private String action;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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

    @Override
    public String toString() {
        return "GatewayAction{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", modifier='" + modifier + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
