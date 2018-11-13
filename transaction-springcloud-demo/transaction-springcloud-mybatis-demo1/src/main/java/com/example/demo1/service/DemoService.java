package com.example.demo1.service;

import com.example.demo1.pojo.Test;

import java.util.List;

/**
 * @author xuezhijian
 * @date 2018/7/12 下午1:34
 * @description
 */
public interface DemoService {

    List<Test> list();

    int save();

}
