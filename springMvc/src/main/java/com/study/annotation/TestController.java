package com.study.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mytest")
@Controller
public class TestController {
	
	@RequestMapping("/test")
	public String test()throws Exception{
		System.out.println("TestController test..");
		
		return "test";
	}

}
