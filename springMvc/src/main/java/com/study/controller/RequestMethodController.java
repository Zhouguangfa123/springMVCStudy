package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/request_method")
@Controller
public class RequestMethodController {
	
	/*
	 * 请求方法的限定(POST GET PUT DELETE ...)
	 * 
	 **/
	
	//默认情况下 POST GET PUT DELETE 方法都支持
	@RequestMapping("/test1")
	public String test1()throws Exception{
		System.out.println("RequestMethodController test1..");
		
		return "test";
	}
	
	@RequestMapping(value="/test2",method={RequestMethod.GET,RequestMethod.POST})
	public String test2()throws Exception{
		System.out.println("RequestMethodController test2..");
		
		return "test";
	}
	
	@RequestMapping(value="/test3",method={RequestMethod.GET})
	public String test3_1()throws Exception{
		System.out.println("RequestMethodController test3_1..");
		
		return "test";
	}
	
	@RequestMapping(value="/test3",method={RequestMethod.POST})
	public String test3_2()throws Exception{
		System.out.println("RequestMethodController test3_2..");
		
		return "test";
	}
	
	
	
	
	
	
}
