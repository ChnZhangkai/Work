package com.zk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class MsgApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(MsgApplication.class, args);
		
	}
	
}
