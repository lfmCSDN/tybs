package com.sunyard.ipp.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启zuul功能
@EnableEurekaClient
public class ZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
		System.out.println("-----------------------------------------------");
		System.out.println("-----------------------------------------------");
		System.out.println("-------ZuulServerApplication run sussessful----");
		System.out.println("-----------------------------------------------");
		System.out.println("-----------------------------------------------");

	}
}
