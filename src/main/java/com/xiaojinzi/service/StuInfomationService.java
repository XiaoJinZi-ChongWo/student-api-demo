package com.xiaojinzi.service;

import com.xiaojinzi.dataobject.StuInformation;
import com.xiaojinzi.form.StudentForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/5.
 * @description
 */
public interface StuInfomationService {

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

    void delete(String stuid);
}
