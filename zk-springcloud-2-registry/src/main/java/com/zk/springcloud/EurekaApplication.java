package com.zk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
	
	public static void main(String[] args) {
//123
//		new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
		SpringApplication.run(EurekaApplication.class, args);
	}
	
}
