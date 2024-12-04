package com.geyao.springbootgeyao.colltroller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试get请求")
public class GeyaoController {
@GetMapping("/geyao")
@ApiOperation(value = "测试get请求")
    public String getName(){
        return "geyao is cool";
    }
}
