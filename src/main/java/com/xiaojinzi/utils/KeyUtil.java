package com.xiaojinzi.utils;

import java.util.Random;

/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/5.
 * @description 主键生成
 */
public class KeyUtil {

    /**
     * 唯一值学生主键生成
     * @return
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(90000)+10000;
        return "2014"+number;
    }
}
