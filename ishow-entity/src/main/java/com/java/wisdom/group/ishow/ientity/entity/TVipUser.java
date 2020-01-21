package com.java.wisdom.group.ishow.ientity.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 会员用户表
 * </p>
 *
 * @author terry
 * @since 2020-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TVipUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员用户表ID
     */
    private Integer vipUserId;

    /**
     * 会员ID
     */
    private Integer vipId;

    /**
     * 用户ID
     */
    private String userId;

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
