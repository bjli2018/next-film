package com.enjoy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BJLI on 2019/12/15.
 */
@RestController
@RequestMapping("/v1/example/")
@Api("ExampleController相关的api")
public class ExampleController {
    @GetMapping("test")
    @ApiOperation(value="测试SwaggerValue", notes="测试SwaggerNotes")
    @ApiImplicitParam(name="test", value="入参str",paramType = "query", required=true, dataType="String")
    public String test(String test){
        System.out.println("str=" + test);
        return "test=" + test;
    }
}
