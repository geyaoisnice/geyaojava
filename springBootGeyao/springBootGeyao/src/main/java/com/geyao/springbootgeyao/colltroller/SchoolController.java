package com.geyao.springbootgeyao.colltroller;

import com.geyao.springbootgeyao.pojo.School;
import com.geyao.springbootgeyao.pojo.User;
import com.geyao.springbootgeyao.service.SchoolService;
import com.geyao.springbootgeyao.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "学校管理")
@RequestMapping("/school")
public class SchoolController {
    @Resource
    private SchoolService schoolService;
    @PostMapping("/add")
    @ApiOperation(value = "添加学校")
    public ResponseResult<Void> addUser(School school){
        schoolService.addSchool(school);
        return ResponseResult.success(null);
    }
    @GetMapping("/getList")
    @ApiOperation(value = "查询全部学校")
    public ResponseResult<List<School>> findAllSchool(){
        List<School> schoolList = schoolService.findAllSchool();
        return ResponseResult.success(schoolList);
    }
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除学校")
    public ResponseResult<Void> deleteSchool(@RequestParam @ApiParam(value = "学校Id") Integer schoolId){
        schoolService.deleteSchool(schoolId);
        return ResponseResult.success(null);
    }
    @ApiOperation(value = "更新学校")
    @PostMapping("/update")
    public ResponseResult<Void> updateSchool(School school){
        schoolService.updateSchool(school);
        return ResponseResult.success(null);
    }
}
