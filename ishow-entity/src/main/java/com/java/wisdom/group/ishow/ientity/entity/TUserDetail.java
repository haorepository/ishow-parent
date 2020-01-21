package com.java.wisdom.group.ishow.ientity.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户详细信息表
 * </p>
 *
 * @author terry
 * @since 2020-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TUserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户详细信息表Id
     */
    private String userDetailId;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户身份证标号
     */
    private String userIdcard;

    /**
     * 用户头像，使用地址
     */
    private String userHead;

    /**
     * 用户住址
     */
    private String userAddress;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户电话号码
     */
    private String userPhoneNo;

    /**
     * 用户身份证正面，使用图片地址
     */
    private String userIdcardFront;

    /**
     * 用户身份证背面，使用图片地址
     */
    private String userIdcardBack;

    /**
     * 用户出生日期
     */
    private LocalDateTime userBirth;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 创建时间（注册日期）
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
