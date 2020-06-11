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
@TableName(value = "t_gateway_user")
public class GatewayUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreater() {
        return creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    @Override
    public String toString() {
        return "GatewayUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", modifier='" + modifier + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
