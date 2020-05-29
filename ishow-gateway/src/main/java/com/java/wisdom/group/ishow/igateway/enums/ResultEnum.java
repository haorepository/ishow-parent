package com.java.wisdom.group.ishow.igateway.enums;

/**
 * 数据操作结果枚举类
 * @author     ： terry
 * @date       ： Created in 2020/4/2 17:34
 */
public enum ResultEnum {
    INSERT(3,"insert"),
    UPDATE(2,"update"),
    DELETE(2,"delete"),
    SUCCESS(1,"SUCCESS"),
    FAIL(0,"FAIL");
    private Integer code;
    private String value;

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    ResultEnum(Integer code, String value){
        this.code = code;
        this.value = value;
    }
}
