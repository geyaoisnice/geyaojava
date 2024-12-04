package com.geyao.springbootgeyao.colltroller;

import com.geyao.springbootgeyao.pojo.User;
import com.geyao.springbootgeyao.service.UserService;
import com.geyao.springbootgeyao.util.ResponseResult;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/test")
    @ApiOperation(value = "测试接口能否运行(可忽略)")
    public List<Map<String,Object>> getUser(){
        return jdbcTemplate.queryForList("select * from geyao_user");
    }
    @PostMapping("/add")
    @ApiOperation(value = "添加用户")
    public ResponseResult<Void> addUser(User user){
            userService.addUser(user);
        return ResponseResult.success(null);
    }
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除用户")
    public ResponseResult<Void> deleteUser(@RequestParam @ApiParam(value = "用户Id") Integer userId){
        userService.deleteUser(userId);
        return ResponseResult.success(null);
    }
    @ApiOperation(value = "更新用户")
    @PostMapping("/update")
    public ResponseResult<Void> updateUser(User user){
        userService.updateUser(user);
        return ResponseResult.success(null);
    }
    @ApiOperation(value = "分页查询用户")
    @PostMapping("/getPageList")
    public PageInfo<User> getAllUser(@RequestParam @ApiParam(value = "页码") int pageNum, @RequestParam @ApiParam(value = "页数") int pageSize){
        return userService.getAllUser(pageNum,pageSize);
    }
    @ApiOperation(value = "根据Id查询用户")
    @GetMapping("/getUserId")
    public ResponseResult<User> getUserById(@ApiParam(value = "用户id")Integer userId){
        User user = userService.findUserById(userId);
        if (user != null) {
            return ResponseResult.success(user);
        } else {
            return ResponseResult.failure(404, "用户未找到");
        }
    }
    @GetMapping("/getList")
    @ApiOperation(value = "查询全部用户")
    public ResponseResult<List<User>> getAllUser(){
        List<User> userList = userService.findAllUser();
        return ResponseResult.success(userList);
    }
}
