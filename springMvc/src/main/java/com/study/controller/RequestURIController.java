package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/request_uri")
@Controller
public class RequestURIController {
	
	/*
	 * 使用@RequestMapping来映射限定请求的uri地址
	 */
	
	
	
	/*1.普通URL路径映射*/
//	@RequestMapping(value="/test1")
//	@RequestMapping(value={"/test1","/mytest"})
//	@RequestMapping({"/test1","/mytest"})
//	@RequestMapping({"/test1"})
	@RequestMapping("/test1")
	public String test1()throws Exception{
		System.out.println("RequestURIController test1..");
		
		return "test";
	}
	
	
	/*2.URI模板模式映射*/
	
	@RequestMapping("/test2/{name}")
	public String test2(@PathVariable String name)throws Exception{
		System.out.println("RequestURIController test2..");
		System.out.println("name = "+name);
		return "test";
	}
	
	@RequestMapping("/test3/name/{name}/age/{age}")
	public String test3(@PathVariable String name,@PathVariable int age)throws Exception{
		System.out.println("RequestURIController test3..");
		System.out.println("name = "+name);
		System.out.println("age = "+age);
		return "test";
	}
	
	// /test4/user?id=1
	// /test4/user/1
	@RequestMapping("/test4/user/{id}")
	public String test4(@PathVariable int id)throws Exception{
		System.out.println("RequestURIController test4..");
		System.out.println("id = "+id);
		return "test";
	}
	
	
	
	/*3.Ant风格的URL路径映射*/
	
//	@RequestMapping("/test5/*")
	@RequestMapping("/test5/**")
	public String test5()throws Exception{
		System.out.println("RequestURIController test5..");
		
		return "test";
	}
	
//	@RequestMapping("/test6/?")
	@RequestMapping("/test6/???")
	public String test6()throws Exception{
		System.out.println("RequestURIController test6..");
		
		return "test";
	}
	
	@RequestMapping("/test7/???/{name}")
	public String test7(@PathVariable String name)throws Exception{
		System.out.println("RequestURIController test7..");
		System.out.println("name = "+name);
		return "test";
	}
	
	
	/*4.正则表达式风格的URL路径映射*/
	
	//{变量名:正则表达式}
	@RequestMapping("/test8/{id:\\d+}")
	public String test8(@PathVariable int id)throws Exception{
		System.out.println("RequestURIController test8..");
		System.out.println("id = "+id);
		return "test";
	}
	
	// test9/abcd-123
//	@RequestMapping("/test9/{name:^[a-z]{4}-\\d{3}$}")
	@RequestMapping("/test9/{name:^briup-[a-z]{1,5}-\\d{1,3}$}")
	public String test9(@PathVariable String name)throws Exception{
		System.out.println("RequestURIController test9..");
		System.out.println("name = "+name);
		return "test";
	}
	
	
}
