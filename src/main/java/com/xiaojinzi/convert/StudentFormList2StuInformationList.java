package com.xiaojinzi.convert;

import com.xiaojinzi.dataobject.StuInformation;
import com.xiaojinzi.form.StudentForm;
import com.xiaojinzi.utils.KeyUtil;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/6.
 * @description 批量添加集合转换并添加主键
 */
public class StudentFormList2StuInformationList {


    public static StuInformation convert(StudentForm studentForm){
        StuInformation stuInformation = new StuInformation();
        BeanUtils.copyProperties(studentForm,stuInformation);
        stuInformation.setStuId(KeyUtil.getUniqueKey());
        return stuInformation;
    }

    public static List<StuInformation> convert(List<StudentForm> studentForms){
        return studentForms.stream().map(e->convert(e)).collect(Collectors.toList());
    }
}
