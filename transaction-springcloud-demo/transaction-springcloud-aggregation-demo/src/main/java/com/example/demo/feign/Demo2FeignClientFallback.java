package com.example.demo.feign;

import com.example.demo.dto.AccountBalanceDTO;

/**
 * @author xuezhijian
 * @date 2018/7/30 上午1:02
 * @description
 */
public class Demo2FeignClientFallback implements Demo2FeignClient {


    @Override
    public void deduct(AccountBalanceDTO accountBalanceDTO) {

    }

    @Override
    public void increase(AccountBalanceDTO accountBalanceDTO) {

    }
}
