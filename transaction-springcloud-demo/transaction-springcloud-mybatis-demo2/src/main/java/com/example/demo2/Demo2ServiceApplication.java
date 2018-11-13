package com.example.demo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xuezhijian
 * @date 2018/8/10 下午3:06
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.example.demo2.mapper")
public class Demo2ServiceApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Demo2ServiceApplication.class, args);
    }

    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

}
