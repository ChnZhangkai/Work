package com.zk.springcloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {
	
	@RequestMapping("/send")
	public String test(){
		
		System.out.println("被调用");
		
		return "end";
		
	}
	
}
