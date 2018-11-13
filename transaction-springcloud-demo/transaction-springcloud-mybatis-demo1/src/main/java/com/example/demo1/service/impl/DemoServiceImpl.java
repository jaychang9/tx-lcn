package com.example.demo1.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.example.demo1.feign.Demo2FeignClient;
import com.example.demo1.mapper.TestMapper;
import com.example.demo1.pojo.Test;
import com.example.demo1.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xuezhijian
 * @date 2018/7/12 下午1:34
 * @description
 */
@Service
public class DemoServiceImpl implements DemoService {
    private final static Logger _LOG = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private Demo2FeignClient demo2Client;


    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> list() {
        return testMapper.findAll();
    }

    @Override
    @TxTransaction(isStart = true)
    @Transactional
    public int save() {

        int rs1 = testMapper.save("mybatis-hello-1");

        int rs2 = demo2Client.save();

//        int rs22 = demo2Client.save();

        //int v = 100/0;

        return rs1+rs2;
    }
}
