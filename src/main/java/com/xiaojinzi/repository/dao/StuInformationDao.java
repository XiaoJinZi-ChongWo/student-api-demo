package com.xiaojinzi.repository.dao;

import com.github.pagehelper.PageHelper;
import com.xiaojinzi.dataobject.StuInformation;
import com.xiaojinzi.repository.mapper.StuInformationMapper;
import com.xiaojinzi.utils.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/29.
 * @description dao
 */

@Repository
public class StuInformationDao {

    @Autowired
    private StuInformationMapper stuInformationMapper;

    public StuInformation findOne(String stuid){
        return stuInformationMapper.findOne(stuid);
    }

    public Map<String,Object> findByCondition(Integer page,Integer size,String stuName,Integer minAge,Integer maxAge){
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(page,size);
        List<StuInformation> list = stuInformationMapper.findByCondition(stuName,minAge,maxAge);
        Page<StuInformation> listCountary = (Page<StuInformation>)list;
        Long count = listCountary.getTotal();
        map.put("total",count);
        map.put("data",list);
        return map;
//        return PageHelperUtil.selectByPage(page,size,stuInformationMapper.findByCondition(stuName,minAge,maxAge));
    }


}
