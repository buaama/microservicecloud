package com.mzz.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetMyRibbonRule {
    @Bean
    public IRule getRule()
    {
        return new MyRibbonRule();
    }
}
