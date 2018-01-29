package com.xiaojinzi.service.impl;

import com.xiaojinzi.convert.StudentFormList2StuInformationList;
import com.xiaojinzi.dataobject.StuInformation;
import com.xiaojinzi.enums.ResultEnum;
import com.xiaojinzi.exception.StuInformationException;
import com.xiaojinzi.form.StudentForm;
import com.xiaojinzi.repository.StuInformationRepository;
import com.xiaojinzi.repository.dao.StuInformationDao;
import com.xiaojinzi.service.StuInfomationService;
import com.xiaojinzi.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/5.
 * @description
 */
@Service
@Slf4j
public class StuInformationServiceImpl implements StuInfomationService {

    @Autowired
    private StuInformationRepository repository;

    @Autowired
    private StuInformationDao stuInformationDao;


    @Override
    public Page<StuInformation> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Map<String, Object> findByCondition(Integer page, Integer size, String stuName, Integer minAge, Integer maxAge) {
        return stuInformationDao.findByCondition(page, size, stuName, minAge, maxAge);
    }

    @Override
    public StuInformation findByMbOne(String stuid) {
        return stuInformationDao.findOne(stuid);
    }

    @Override
    public StuInformation findOne(String stuId) {
        return repository.findOne(stuId);
    }

    @Override
    @Transactional
    public List<StuInformation> save(List<StudentForm> studentForms) {
        List<StuInformation> result = repository.save(StudentFormList2StuInformationList.convert(studentForms));
        if(result.size()!=studentForms.size()){
            log.error("【批量数据插入出错】 批量数据插入错误 result = {}",result);
            throw new StuInformationException(ResultEnum.LIST_SAVE_ERROR);
        }
        return result;
    }

    @Override
    public StuInformation add(StudentForm form) {
        StuInformation stuInformation = new StuInformation();
        BeanUtils.copyProperties(form,stuInformation);
        stuInformation.setStuId(KeyUtil.getUniqueKey());
        return repository.save(stuInformation);
    }

    @Override
    public StuInformation update(StuInformation stuInformation) {
        StuInformation match = repository.findOne(stuInformation.getStuId());
        if(match==null){
            log.error("【更新操作】 数据库出错 stuInformation={}",stuInformation);
            throw new StuInformationException(ResultEnum.PARAM_ERROR_ADD);
        }
        StuInformation result = repository.save(stuInformation);
        return result;
    }

    @Override
    public void delete(String stuid) {
        StuInformation stuInformation = repository.findOne(stuid);
        if(stuInformation==null){
            log.error("【更新操作】 数据库出错 stuInformation={}",stuInformation);
            throw new StuInformationException(ResultEnum.PARAM_ERROR_ADD);
        }
        repository.delete(stuid);
    }
}
