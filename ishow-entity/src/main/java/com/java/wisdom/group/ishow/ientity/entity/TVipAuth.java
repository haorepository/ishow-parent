package com.java.wisdom.group.ishow.ientity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * VIP权限表
 * </p>
 *
 * @author terry
 * @since 2020-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TVipAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * vip权限表ID
     */
    @TableId(value = "vip_auth_id",type = IdType.AUTO)
    private Integer vipAuthId;

    /**
     * vip表ID
     */
    private Integer vipId;

    /**
     * 权限表ID
     */
    private Integer authId;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;


}
