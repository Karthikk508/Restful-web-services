package com.karthik.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
	
	
	@GetMapping("/hello-world")
	public String helloWorld() {

		return "hai hello";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloworldbean() {
	  
		return new HelloWorldBean("hello buddy");
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		
		return new HelloWorldBean(String.format("HelloWorld , %s ", name));
	}
	
}
