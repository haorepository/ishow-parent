package com.java.wisdom.group.ishow.iuserprovider.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
