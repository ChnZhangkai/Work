package com.zk.springcloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {
	
	/**
	 * 服务提供测试
	 * @return
	 */
	@RequestMapping("/send")
	public String test(){
		
		System.out.println("被调用");
		
		return "服务提供者被调用";
		
	}
	
}
