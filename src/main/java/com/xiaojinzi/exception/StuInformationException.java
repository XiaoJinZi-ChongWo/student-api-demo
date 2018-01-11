package com.xiaojinzi.exception;

import com.xiaojinzi.enums.ResultEnum;

/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/5.
 * @description 异常处理
 */
public class StuInformationException extends RuntimeException{

    private Integer code;

    public StuInformationException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
