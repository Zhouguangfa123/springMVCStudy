package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/request_header")
@Controller
public class RequestHeaderController {
	
	/*
	 * 请求头信息的映射
	 */
	
	
	//请求头数据中有指定参数名
	@RequestMapping(value="/test1",headers={"Accept"})
	public String test1()throws Exception{
		System.out.println("RequestHeaderController test1..");
		
		return "test";
	}
	@RequestMapping(value="/test2",headers={"my-test"})
	public String test2()throws Exception{
		System.out.println("RequestHeaderController test2..");
		
		return "test";
	}
	
	
	//请求头数据中必须没有指定参数名
	@RequestMapping(value="/test3",headers={"!my-test"})
	public String test3()throws Exception{
		System.out.println("RequestHeaderController test3..");
		
		return "test";
	}
	
	//请求头数据中指定参数名=值
	@RequestMapping(value="/test4",headers={"my-test=test"})
	public String test4()throws Exception{
		System.out.println("RequestHeaderController test4..");
		
		return "test";
	}
	
	//请求头数据中指定参数名!=值
	@RequestMapping(value="/test5",headers={"my-test!=test"})
	public String test5()throws Exception{
		System.out.println("RequestHeaderController test5..");
		
		return "test";
	}
	
	//可以设置多个条件
	@RequestMapping(value="/test6",headers={"Accept=application/json","Content-Type=application/json"})
	public String test6()throws Exception{
		System.out.println("RequestHeaderController test6..");
		
		return "test";
	}
	
	
	//请求给服务器带过去什么数据(Content-Type)
	//那么服务器就要消费(consumes)什么数据
	@RequestMapping(value="/test7",consumes="application/json")
	public String test7()throws Exception{
		System.out.println("RequestHeaderController test7..");
		
		return "test";
	}
	

	//请求希望最终接收什么数据(Accept)
	//那么服务器就要生产(produces)什么数据
	@RequestMapping(value="/test8",produces="application/json")
	public ModelAndView test8()throws Exception{
		System.out.println("RequestHeaderController test8..");
		ModelAndView mv = new ModelAndView("hello");

		mv.addObject("name", "tom");
		
		return mv;
	}
	
	@RequestMapping(value="/test9",produces="application/json",consumes="application/json",method=RequestMethod.POST)
	public String test9()throws Exception{
		System.out.println("RequestHeaderController test9..");
		
		return "test";
	}
	
}
