package com.example.demo1.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.example.demo1.dto.AccountBalanceDTO;
import com.example.demo1.exception.BizException;
import com.example.demo1.feign.Demo2FeignClient;
import com.example.demo1.mapper.TestMapper;
import com.example.demo1.pojo.Test;
import com.example.demo1.service.DemoService;
import org.apache.commons.lang3.RandomUtils;
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
@SuppressWarnings("AlibabaUndefineMagicConstant")
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
    @Transactional(rollbackFor = Exception.class)
    public int save() {

        int rs1 = testMapper.save("mybatis-hello-1");

        int rs2 = demo2Client.save();

//        int rs22 = demo2Client.save();

        //int v = 100/0;

        return rs1+rs2;
    }

    @TxTransaction(isStart = false)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void dedcut(AccountBalanceDTO accountBalanceDTO) {
        Test test = testMapper.selectById(accountBalanceDTO.getAccountId());
        test.setBalance(test.getBalance().subtract(accountBalanceDTO.getAmount()));
//        if(RandomUtils.nextInt(0,100) % 3 == 0){
//            throw new RuntimeException("demo1模拟业务执行抛出异常");
//        }
        int i = testMapper.updateBalanceById(test);
        if(i == 0 ){
            throw new BizException("更新失败");
        }
    }

    @TxTransaction(isStart = false)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void increase(AccountBalanceDTO accountBalanceDTO) {
        Test test = testMapper.selectById(accountBalanceDTO.getAccountId());
        test.setBalance(test.getBalance().add(accountBalanceDTO.getAmount()));
        int i = testMapper.updateBalanceById(test);
        if(i == 0 ){
            throw new BizException("更新失败");
        }
    }


}
