package com.mzz.microservice.cfgbeans;

import com.mzz.microservice.entities.Dept;
import com.mzz.myrule.GetMyRibbonRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    @LoadBalanced //load balance
    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();//RestTemplate用于http访问
    }
//    @Bean
//    public IRule getIRule()
//    {
//        return new GetMyRibbonRule;//use random rule to put load balance into practice
//    }

}
