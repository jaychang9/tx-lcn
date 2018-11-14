package com.example.demo.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.example.demo.dto.AccountBalanceDTO;
import com.example.demo.dto.TransferDTO;
import com.example.demo.feign.Demo2FeignClient;
import com.example.demo.service.DemoService;
import com.example.demo.feign.Demo1FeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuezhijian
 * @date 2018/7/12 下午1:34
 * @description
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private Demo1FeignClient demo1Client;

    @Autowired
    private Demo2FeignClient demo2Client;

    /***
     * isStart = true 表示是事务发起方
     *
     * @param transferDTO
     */
    @TxTransaction(isStart = true, readOnly = true)
    @Override
    public void transfer(TransferDTO transferDTO) {
        // 模拟扣减余额
        AccountBalanceDTO fromAccountBalanceDTO = AccountBalanceDTO.builder().accountId(transferDTO.getFromAcctId())
                .amount(transferDTO.getAmount()).build();
        demo1Client.deduct(fromAccountBalanceDTO);
        // 模拟增加余额
        AccountBalanceDTO toAccountBalanceDTO = AccountBalanceDTO.builder().accountId(transferDTO.getToAcctId())
                .amount(transferDTO.getAmount()).build();
        demo2Client.increase(toAccountBalanceDTO);
    }
}
