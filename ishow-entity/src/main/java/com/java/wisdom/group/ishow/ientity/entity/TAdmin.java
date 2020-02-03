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
 * 后台管理员表
 * </p>
 *
 * @author terry
 * @since 2020-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员ID
     */
    @TableId(value = "admin_id",type = IdType.ASSIGN_UUID)
    private String adminId;

    /**
     * 管理员名称
     */
    private String adminName;

    /**
     * 管理员工号
     */
    private String adminCode;

    /**
     * 管理员密码
     */
    private String adminPassword;

    /**
     * 管理员电话
     */
    private String adminPhoneNo;

    /**
     * 管理员邮箱
     */
    private String adminEmail;

    /**
     * 管理员身份证
     */
    private String adminIdcard;

    /**
     * 管理员出生日期
     */
    private LocalDateTime adminBirth;

    /**
     * 管理员住址
     */
    private String adminAddress;

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
