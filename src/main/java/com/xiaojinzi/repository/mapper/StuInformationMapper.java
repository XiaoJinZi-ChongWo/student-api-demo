package com.xiaojinzi.repository.mapper;

import com.xiaojinzi.dataobject.StuInformation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/29.
 * @description
 */
public interface StuInformationMapper {

    /**
     * id查询
     * @param stuid
     * @return
     */
    @Select("select * from stu_information where stu_id=#{stuid,jdbcType=VARCHAR}")
    @Results({
            @Result(column = "stu_id",property = "stuId"),
            @Result(column = "stu_name",property = "stuName"),
            @Result(column = "stu_sex",property = "stuSex"),
            @Result(column = "stu_magor",property = "stuMagor"),
            @Result(column = "stu_age",property = "stuAge"),
            @Result(column = "stu_grade",property = "stuGrade"),
            @Result(column = "stu_department",property = "stuDepartment"),
            @Result(column = "stu_class",property = "stuClass")
    })
    StuInformation findOne(@Param("stuid") String stuid);

    /**
     * 组合条件查询
     * @param stuName
     * @param minAge
     * @param maxAge
     * @return
     */
    List<StuInformation> findByCondition(@Param("stuName") String stuName,@Param("minAge") Integer minAge,@Param("maxAge") Integer maxAge);
}
