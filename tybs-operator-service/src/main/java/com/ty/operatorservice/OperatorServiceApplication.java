package com.ty.operatorservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("${scan.packages}")
@MapperScan("com.ty.operatorservice.mapper")
@SpringBootApplication
//@EnableDiscoveryClient //开启服务发现
@EnableFeignClients //开启负载均衡 如何使用待定
//@EnableCircuitBreaker //开启断路器仪表盘
@EnableEurekaClient
public class OperatorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperatorServiceApplication.class, args);
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("--------OperatorService run sussessful---------");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
    }
}
