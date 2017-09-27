package com.zk.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TestService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "testFallback")
	public String testService(){
		
		return restTemplate.getForObject("http://smsapp/send", String.class);
		
	}
	
	public String testFallback(){
		
		return "服务发生异常";
		
	}
	
}
