package com.ty.adminservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("${scan.packages}")
@MapperScan("com.ty.adminservice.mapper")
@SpringBootApplication
@EnableDiscoveryClient //开启服务发现
@EnableFeignClients //开启负载均衡 如何使用待定
@EnableCircuitBreaker //开启断路器仪表盘
@EnableEurekaClient
public class AdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class, args);
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("-------------AdminService run sussessful-----------");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");

    }

    //开启zipkin追踪页面
    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}

