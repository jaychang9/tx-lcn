package com.example.demo1.feign;

import com.example.demo1.pojo.Test;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author xuezhijian
 * @date 2018/7/28 下午5:06
 * @description
 */
@FeignClient(name = "lcn-mybatis-demo2", fallback = Demo2FeignClientFallback.class)
public interface Demo2FeignClient {

    @RequestMapping(value = "/demo/list",method = RequestMethod.GET)
    List<Test> list();


    @RequestMapping(value = "/demo/save",method = RequestMethod.GET)
    int save();
}
