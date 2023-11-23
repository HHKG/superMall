package com.hhk.suppermall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试接口")
public class HelloWord {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
