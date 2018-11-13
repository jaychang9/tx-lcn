package com.example.demo2.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.example.demo2.mapper.TestMapper;
import com.example.demo2.pojo.Test;
import com.example.demo2.service.DemoService;
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
    private TestMapper testMapper;

    @Override
    public List<Test> list() {
        return testMapper.findAll();
    }

    @TxTransaction(isStart = false)
    @Override
    @Transactional
    public int save() {

        int rs = testMapper.save("mybatis-hello-2");

        return rs;
    }
}
