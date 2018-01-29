package com.xiaojinzi.service;

import com.xiaojinzi.dataobject.StuInformation;
import com.xiaojinzi.form.StudentForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/5.
 * @description
 */
public interface StuInfomationService {

    /** JPA操作 .*/
    /** 查询所有 .*/
    Page<StuInformation> findAll(Pageable pageable);

    /** 单个结果查询 .*/
    StuInformation findOne(String stuId);

    /** 集合插入 .*/
    List<StuInformation> save(List<StudentForm> studentForms);

    /** 单个存储 .*/
    StuInformation add(StudentForm form);

    /** 更新 .*/
    StuInformation update(StuInformation stuInformation);

    /** 删除 .*/
    void delete(String stuid);


    /** Mybatis操作 .*/
    /** 查询单个 .*/
    StuInformation findByMbOne(String stuid);

    /** 多条件查询 .*/
    Map<String,Object> findByCondition(Integer page,Integer size,String stuName,Integer minAge,Integer maxAge);




}
