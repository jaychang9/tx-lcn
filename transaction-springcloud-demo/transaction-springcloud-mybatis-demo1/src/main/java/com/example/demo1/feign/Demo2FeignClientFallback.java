package com.example.demo1.feign;

import com.example.demo1.pojo.Test;

import java.util.List;

/**
 * @author xuezhijian
 * @date 2018/7/30 上午1:02
 * @description
 */
public class Demo2FeignClientFallback implements Demo2FeignClient {

    @Override
    public List<Test> list() {
        System.out.println("进入断路器-list。。。");
        throw new RuntimeException("list 保存失败.");
    }

    @Override
    public int save() {
        System.out.println("进入断路器-save。。。");
        throw new RuntimeException("save 保存失败.");
    }
}
