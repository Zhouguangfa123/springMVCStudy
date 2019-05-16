package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/binding_data")
@Controller
public class BindingDataController {
	
	/*
	 * springmvc中的如何获取客户端传的参数
	 */
	
	
	// 参数名和变量名一致,可以自动接收参数(POST或GET都可以)
	// /test1?name=tom
	@RequestMapping("/test1")
	public String test1(String name)throws Exception{
		System.out.println("BindingDataController test1..");
		
		System.out.println("name = "+name);
		
		return "test";
	}
	
	// /test2?name=tom
	// @RequestParam("name")可以从请求的参数中拿出指定名字的参数值
	@RequestMapping("/test2")
	public String test2(@RequestParam("name") String username)throws Exception{
		System.out.println("BindingDataController test2..");
		
		System.out.println("username = "+username);
		
		return "test";
	}
	
	// /test3
	// required属性默认值是true
	// required表示当前这个参数是否一定要有
	@RequestMapping("/test3")
	public String test3(@RequestParam(value="name",required=false) String username)throws Exception{
		System.out.println("BindingDataController test3..");
		
		System.out.println("username = "+username);
		
		return "test";
	}
	
	// /test4
	// /test4?name=tom
	// defaultValue属性可以设置参数的默认值
	// 如果客户端没有传这个参数,那么这个参数就要使用默认值
	// 注:defaultValue属性值中,是支持SpringEL的
	// defaultValue="SpringEL表达式"
	@RequestMapping("/test4")
	public String test4(@RequestParam(value="name",required=false,defaultValue="hello") String username)throws Exception{
		System.out.println("BindingDataController test4..");
		
		System.out.println("username = "+username);
		
		return "test";
	}
	
	
	
}
