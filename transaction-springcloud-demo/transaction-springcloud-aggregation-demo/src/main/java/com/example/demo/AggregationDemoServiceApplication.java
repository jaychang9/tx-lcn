package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author xuezhijian
 * @date 2018/8/10 下午3:06
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.example.demo.feign"})
public class AggregationDemoServiceApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(AggregationDemoServiceApplication.class, args);
    }

    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

}
