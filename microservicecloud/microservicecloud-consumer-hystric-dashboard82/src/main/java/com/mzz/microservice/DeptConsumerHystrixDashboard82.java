package com.mzz.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableEurekaClient
@EnableDiscoveryClient
public class DeptConsumerHystrixDashboard82 {
    public static void main(String[] args )
    {
        SpringApplication.run(DeptConsumerHystrixDashboard82.class,args);
    }
}
