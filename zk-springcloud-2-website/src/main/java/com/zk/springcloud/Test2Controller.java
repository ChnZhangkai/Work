package com.zk.springcloud;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Test2Controller {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("test2")
	public String test2(){
		
		//"http://" + host + ":" + port + "/send"
		@SuppressWarnings({ "unchecked", "rawtypes" }) //去除警告黄线
		String result = restTemplate.getForObject("http://smsapp/send", String.class,new HashMap());
		
		System.out.println("调用了：" + result);
		
		return result;
		
	}
	
	
}
