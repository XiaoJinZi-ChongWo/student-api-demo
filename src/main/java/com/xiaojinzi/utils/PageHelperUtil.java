package com.xiaojinzi.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/29.
 * @description 分页工具
 */
public class PageHelperUtil<T> {

    /**
     * 分页
     * @param page
     * @param size
     * @param list
     * @return
     */
    public static Map<String,Object> selectByPage(Integer page,Integer size,List list){
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(page,size);
        Page listCountary = (Page)list;
        Long count = listCountary.getTotal();
        map.put("data",list);
        map.put("total",count);
        return map;
    }
}
