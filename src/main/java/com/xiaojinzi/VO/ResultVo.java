package com.xiaojinzi.VO;

import lombok.Data;

/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/5.
 * @description 返回json 内容
 */
@Data
public class ResultVo<T> {

    /** 状态码 .*/
    private Integer code;

    /** 消息 .*/
    private String msg;

    /** 具体值 .*/
    private T data;

}
