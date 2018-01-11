package com.xiaojinzi.utils;

import com.xiaojinzi.VO.ResultVo;
import com.xiaojinzi.enums.ResultEnum;

/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/5.
 * @description 返回封装
 */
public class ResultVoUtil {

    /**
     * 成功返回有值
     * @param object
     * @return
     */
    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultEnum.SUCCESS.getCode());
        resultVo.setMsg(ResultEnum.SUCCESS.getMessage());
        resultVo.setData(object);
        return resultVo;
    }

    /**
     * 无值成功返回
     * @return
     */
    public static ResultVo success(){
       return success(null);
    }

    /**
     * 错误返回
     * @param resultEnum
     * @return
     */
    public static ResultVo error(ResultEnum resultEnum){
        ResultVo resultVo =  new ResultVo();
        resultVo.setCode(resultEnum.getCode());
        resultVo.setMsg(resultEnum.getMessage());
        return resultVo;
    }
}
