package com.zk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //开启断路器
public class WebsiteApplication {
	
	@Bean
	@LoadBalanced //ribbon,eureka,resttemplate集成(ribbon负载均衡者)
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(WebsiteApplication.class, args);
		
	}
	
}
