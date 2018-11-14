package com.example.demo2.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.example.demo2.dto.AccountBalanceDTO;
import com.example.demo2.exception.BizException;
import com.example.demo2.mapper.TestMapper;
import com.example.demo2.pojo.Test;
import com.example.demo2.service.DemoService;
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
    private TestMapper testMapper;

    @Override
    public List<Test> list() {
        return testMapper.findAll();
    }

    @TxTransaction(isStart = false,rollbackFor = Exception.class)
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save() {
        boolean flag = RandomUtils.nextBoolean();
        int rs = 0;
        if(flag) {
            System.out.println("正常执行");
            rs = testMapper.save("mybatis-hello-2");
        }else{
            System.out.println("抛出异常");
            int a = 1 / 0;
        }
        return rs;
    }

    @TxTransaction(isStart = false,rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void dedcut(AccountBalanceDTO accountBalanceDTO) {
        Test test = testMapper.selectById(accountBalanceDTO.getAccountId());
        test.setBalance(test.getBalance().subtract(accountBalanceDTO.getAmount()));
        int i = testMapper.updateBalanceById(test);
        if(i == 0 ){
            System.out.println("更新失败");
            throw new BizException("更新失败");
        }
    }

    @SuppressWarnings("All")
    @TxTransaction(isStart = false,rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void increase(AccountBalanceDTO accountBalanceDTO) {
        Test test = testMapper.selectById(accountBalanceDTO.getAccountId());
        test.setBalance(test.getBalance().add(accountBalanceDTO.getAmount()));
        // 模拟抛出业务执行异常
//        if(RandomUtils.nextInt(0,100) % 3 == 0){
//            int a = 1 / 0;
//        }
        int i = testMapper.updateBalanceById(test);
        // 更新不成功，必须将异常抛出，以便做补偿用(这里不加的话，最终结果会不一致)
        if(i == 0 ){
            System.out.println("更新失败");
            throw new BizException("更新失败");
        }
    }
}
