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
 * 测试表
 * </p>
 *
 * @author terry
 * @since 2020-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TestInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "test_id", type = IdType.AUTO)
    private Integer testId;

    private String testName;

    private String creater;

    private LocalDateTime createTime;

    private String modifier;

    private LocalDateTime modifyTime;

    /**
     * 1：逻辑删除，0：逻辑未删除
     */
    private Integer logicDelete;


}
