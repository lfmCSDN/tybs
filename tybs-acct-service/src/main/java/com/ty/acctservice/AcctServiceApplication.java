package com.ty.acctservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.ty.acctservice.mapper")
//@EnableDiscoveryClient //开启服务发现
@EnableFeignClients //开启负载均衡 如何使用待定
//@EnableCircuitBreaker //开启断路器仪表盘
@EnableEurekaClient
public class AcctServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcctServiceApplication.class, args);
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("-----AcctServiceApplication run  sussessful----");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
    }

    //开启zipkin追踪页面
    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
