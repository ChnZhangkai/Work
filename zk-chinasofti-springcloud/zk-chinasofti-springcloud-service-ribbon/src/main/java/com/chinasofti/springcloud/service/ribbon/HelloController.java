package com.chinasofti.springcloud.service.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping("/hi")
	public String hi(@RequestParam String name){
		return helloService.HiService(name);
	}
	
}
