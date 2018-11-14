package com.example.demo.controller;

import com.example.demo.dto.TransferDTO;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/transfer")
    public void transfer(TransferDTO transferDTO){
        demoService.transfer(transferDTO);
    }

}
