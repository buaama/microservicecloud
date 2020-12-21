package com.mzz.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//表示自己是eureka注册中心，接收其他服务提供者的注册
public class EurekaServer7001Application {
    public static void main(String[] args)
    {
        SpringApplication.run(EurekaServer7001Application.class,args);
    }
}
