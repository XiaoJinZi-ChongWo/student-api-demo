package com.xiaojinzi.controller;

import com.xiaojinzi.VO.ResultVo;
import com.xiaojinzi.dataobject.StuInformation;
import com.xiaojinzi.enums.ResultEnum;
import com.xiaojinzi.exception.StuInformationException;
import com.xiaojinzi.form.StudentForm;
import com.xiaojinzi.service.StuInfomationService;
import com.xiaojinzi.utils.ResultVoUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author 金全 wrj008
 * @version 1.0.0 2018/1/5.
 * @description 控制类
 */
@RestController
@RequestMapping("/student")
@Slf4j
public class StuInfoController {

    @Autowired
    private StuInfomationService stuInfomationService;

    /**
     * 单个对象添加
     * @param form
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "添加学生",notes = "根据对象添加")
    @ApiImplicitParam(name = "form",value = "学生实体StudentForm",required = true,dataType = "StudentForm")
    @PostMapping("/add")
    public ResultVo addStudent(@RequestBody StudentForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【添加学生】 参数传递错误 form ={}",form);
            throw new StuInformationException(ResultEnum.PARAM_ERROR_ADD);
        }
        StuInformation result = stuInfomationService.add(form);
        return ResultVoUtil.success(result);
    }


    /**
     * 批量添加
     * @param list
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "批量添加",notes = "集合对象添加")
    @PostMapping("/batchadd")
    public ResultVo batchAdd(@RequestBody List<StudentForm> list, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【添加学生】 参数传递错误 list ={}",list);
            throw new StuInformationException(ResultEnum.PARAM_ERROR_ADD);
        }
        List<StuInformation> stuInformations = stuInfomationService.save(list);
        return ResultVoUtil.success(stuInformations);
    }

    /**
     * 根据单个查询
     * @param stuid
     * @return
     */
    @ApiOperation(value = "单个查询",notes = "id查询")
    @ApiImplicitParam(name = "stuid",value = "通过id查询",required = true,dataType = "String",paramType = "Path")
    @GetMapping("/findone/{stuid}")
    public ResultVo findOne(@PathVariable String stuid){
        Map<String,String> map = new HashMap<>();
        StuInformation stuInformation = stuInfomationService.findOne(stuid);
        if(stuInformation==null){
            map.put("object","没有该同学");
            return ResultVoUtil.success(map);
        }
        return ResultVoUtil.success(stuInformation);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "分页查询",notes = "分页参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "当前页",required = false,dataType = "Integer",defaultValue = "1",paramType = "Query"),
            @ApiImplicitParam(name = "size",value = "页面显示数",required = false,dataType = "Integer",defaultValue = "10",paramType = "Query")
    })
    @GetMapping("/findAll")
    public ResultVo findAll(@RequestParam(value = "page",defaultValue = "1")Integer page, @RequestParam(value = "size",defaultValue = "10")Integer size){
        PageRequest request = new PageRequest(page-1,size);
        Page<StuInformation> stuInformations = stuInfomationService.findAll(request);
        return ResultVoUtil.success(stuInformations.getContent());
    }

    /**
     * 更新操作
     * @param stuInformation
     * @return
     */
    @ApiOperation(value = "更新操作",notes = "单个更新")
    @ApiImplicitParam(name = "stuInformation",value = "学生实体stuInformation",required = true,dataType = "StuInformation")
    @PutMapping("/update")
    public ResultVo updateStu(@RequestBody StuInformation stuInformation){
        StuInformation result = stuInfomationService.update(stuInformation);
        return ResultVoUtil.success(result);
    }

    /**
     * 删除操作
     * @param stuid
     * @return
     */
    @ApiOperation(value = "删除操作" ,notes = "根据id删除")
    @ApiImplicitParam(name = "stuid",value = "主键删除",required = true,dataType = "String",paramType = "Path")
    @DeleteMapping("/delete/{stuid}")
    public ResultVo deleteStu(@PathVariable String stuid){
        stuInfomationService.delete(stuid);
        return ResultVoUtil.success();
    }


    /**
     * mybatis 单个查询
     * @param stuid
     * @return
     */
    @GetMapping("/find/{stuid}")
    public ResultVo findByMbOne(@PathVariable String stuid){
        StuInformation result = stuInfomationService.findByMbOne(stuid);
        return ResultVoUtil.success(result);
    }

    /**
     * 多条件组合加分页
     * @param page
     * @param size
     * @param stuName
     * @param minAge
     * @param maxAge
     * @return
     */
    @GetMapping("/find/condition")
    public ResultVo findByCondition(@RequestParam(name = "page",defaultValue = "1")Integer page
            ,@RequestParam(name="size",defaultValue = "10") Integer size
            ,@RequestParam(name="stuName",required = false)String stuName
            ,@RequestParam(name="minAge",defaultValue = "1")Integer minAge,@RequestParam(name = "maxAge",required = false)Integer maxAge){
        Map<String,Object> map = stuInfomationService.findByCondition(page,size,stuName,minAge,maxAge);
        return ResultVoUtil.success(map.get("data"));
    }
}
