package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/request_param")
@Controller
public class RequestParamController {
	
	/*
	 * 请求参数的映射
	 */
	
	
	//请求数据中有指定参数名
	@RequestMapping(value="/test1",params={"name"})
	public String test1()throws Exception{
		System.out.println("RequestParamController test1..");
		
		return "test";
	}
	
	//请求数据中没有指定参数名
	@RequestMapping(value="/test2",params={"!name"})
	public String test2()throws Exception{
		System.out.println("RequestParamController test2..");
		
		return "test";
	}
	
	//请求数据中指定参数名和值
	@RequestMapping(value="/test3",params={"name=tom"})
	public String test3()throws Exception{
		System.out.println("RequestParamController test3..");
		
		return "test";
	}
	
	

	//请求数据中指定参数名不等于某个值
	@RequestMapping(value="/test4",params={"name!=tom"})
	public String test4()throws Exception{
		System.out.println("RequestParamController test4..");
		
		return "test";
	}
	
	
	//可以指定多个条件
	@RequestMapping(value="/test5",params={"name=tom","age"})
	public String test5()throws Exception{
		System.out.println("RequestParamController test5..");
		
		return "test";
	}
	
	//请求中,必须包含id、name、age这三个参数
	@RequestMapping(value="/test6",params={"id","name","age"})
	public String test6()throws Exception{
		System.out.println("RequestParamController test6..");
		
		return "test";
	}
	
}
