package com.zk.springcloud;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	DiscoveryClient discoveryClient; 
	
	
	@RequestMapping("test")
	public String test() throws IOException{
		//不通过id,端口来调用；
		//通过服务名来获取实例
		List<ServiceInstance> instances = discoveryClient.getInstances("smsapp");
		ServiceInstance serviceInstance = instances.get(0);
		
		String host = serviceInstance.getHost();
		int port = serviceInstance.getPort();
		
		URL url = new URL("http://" + host + ":" + port + "/send");
		byte[] result = new byte[3];
		
		InputStream input = url.openStream();
		IOUtils.readFully(input, result);
		
		System.out.println(new String(result));
		
		return new String(result);
		
	}
	
}
