package com.qin.wcc.configbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced   //ribbon负载均衡  （spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。）
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    @Bean   //负载均衡规则
    public IRule myRule(){
       return new RandomRule(); //随机的负载均衡
    }
}
