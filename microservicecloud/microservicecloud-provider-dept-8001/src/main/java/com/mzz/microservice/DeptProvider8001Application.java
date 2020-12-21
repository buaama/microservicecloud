package com.mzz.microservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.mzz.microservice.dao.DeptDao")
@SpringBootApplication
@EnableEurekaClient//自动注册eureka服务器（注册中心）
@EnableDiscoveryClient
public class DeptProvider8001Application {
    public static void main(String[] args)
    {
        SpringApplication.run(DeptProvider8001Application.class,args);
    }
}
