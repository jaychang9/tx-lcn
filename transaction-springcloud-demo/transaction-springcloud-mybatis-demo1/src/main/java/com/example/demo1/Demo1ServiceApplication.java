package com.example.demo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.core.env.Environment;


/**
 * @author xuezhijian
 * @date 2018/8/10 下午3:06
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.example.demo1.mapper")
@EnableFeignClients({"com.example.demo1.feign"})
public class Demo1ServiceApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Demo1ServiceApplication.class, args);
    }

    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

}
