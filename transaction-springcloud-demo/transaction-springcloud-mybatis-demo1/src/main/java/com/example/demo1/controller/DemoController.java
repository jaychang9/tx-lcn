package com.example.demo1.controller;

import com.example.demo1.pojo.Test;
import com.example.demo1.rest.BaseResponse;
import com.example.demo1.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zj
 * @date 2018/5/23 下午4:20
 * @description
 */
@RestController
@RequestMapping(value = "/demo",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RefreshScope
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/list")
    public List<Test> list(){
        return demoService.list();
    }

    @RequestMapping("/save")
    public int save(){
        return demoService.save();
    }

}
