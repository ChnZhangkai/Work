package com.zk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务消费者 非负载均衡
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class WebsiteApplication {	
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(WebsiteApplication.class, args);
		
	}
	
}
