package com.java.wisdom.group.ishow.iuserprovider.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 管理员角色表
 * </p>
 *
 * @author terry
 * @since 2020-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TAdminRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员角色表主键
     */
    private Integer adminRoleId;

    /**
     * 管理员ID
     */
    private String adminId;

    /**
     * 角色ID
     */
    private Integer roleId;

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
