package com.xiaojinzi.enums;

import lombok.Getter;

/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/5.
 * @description
 */

@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),
    LIST_SAVE_ERROR(10,"批量存储出错"),
    PARAM_ERROR_ADD(20,"添加学生信息错误")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
