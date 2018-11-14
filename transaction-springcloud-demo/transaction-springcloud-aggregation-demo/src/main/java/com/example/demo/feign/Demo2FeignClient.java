package com.example.demo.feign;

import com.example.demo.dto.AccountBalanceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xuezhijian
 * @date 2018/7/28 下午5:06
 * @description
 */
@FeignClient(name = "lcn-mybatis-demo2", fallback = Demo2FeignClientFallback.class)
public interface Demo2FeignClient {

    @PostMapping("/demo/deduct")
    void deduct(@RequestBody AccountBalanceDTO accountBalanceDTO);

    @PostMapping("/demo/increase")
    void increase(@RequestBody AccountBalanceDTO accountBalanceDTO);
}
