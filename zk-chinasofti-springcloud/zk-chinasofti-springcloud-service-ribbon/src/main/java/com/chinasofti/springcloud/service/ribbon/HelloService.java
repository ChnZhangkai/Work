package com.chinasofti.springcloud.service.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public String HiService(String name){
		return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name, String.class);
	}
	
}
