package com.ty.tybs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("${scan.packages}")
@MapperScan("com.ty.tybs.web.mapper")
//@EnableDiscoveryClient //开启服务发现
@EnableFeignClients //开启负载均衡 如何使用待定
//@EnableCircuitBreaker //开启断路器仪表盘
@EnableEurekaClient
@EnableScheduling
public class TybsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TybsApplication.class, args);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("========================================================================");
        System.out.println("------------------tybsAppliction is successful started up---------------");
        System.out.println("========================================================================");
        System.out.println("------------------------------------------------------------------------");
    }
}
