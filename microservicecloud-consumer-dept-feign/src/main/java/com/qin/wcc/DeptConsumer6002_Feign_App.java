package com.qin.wcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.qin.wcc"})
@ComponentScan("com.qin.wcc")
public class DeptConsumer6002_Feign_App {


    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer6002_Feign_App.class,args);
    }
}
