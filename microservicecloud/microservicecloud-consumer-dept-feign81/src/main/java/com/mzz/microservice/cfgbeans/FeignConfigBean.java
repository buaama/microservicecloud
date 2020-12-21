package com.mzz.microservice.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FeignConfigBean
{
    @LoadBalanced //load balance
    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();//RestTemplate用于http访问
    }
    @Bean
    public IRule getIRule()
    {
        return new RoundRobinRule();//use random rule to put load balance into practice
    }

}

