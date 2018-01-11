package com.xiaojinzi.form;

import lombok.Data;

/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/5.
 * @description 学生表单
 */
@Data
public class StudentForm {

    /** 姓名 .*/
    private String stuName;

    /** 性别 0表示男生，1标识女生 .*/
    private Integer stuSex;

    /** 年龄 .*/
    private Integer stuAge;

    /** 专业 .*/
    private String stuMagor;

    /** 年级 .*/
    private Integer stuGrade;

    /** 院系 .*/
    private String stuDepartment;

    /** 班级 .*/
    private String stuClass;
}
